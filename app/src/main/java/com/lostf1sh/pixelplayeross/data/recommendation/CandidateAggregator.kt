package com.lostf1sh.pixelplayeross.data.recommendation

import com.lostf1sh.pixelplayeross.data.listenbrainz.ListenBrainzRepository
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.playlist.nlp.GenreTaxonomy
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stage 1 of recommendation engine: aggregates candidate tracks across multiple sources in parallel.
 * Sources:
 * 1. Innertube radio graph (YT_RADIO)
 * 2. ListenBrainz Labs similar-artists graph (LB_SIMILAR_ARTIST)
 * 3. Library genre taxonomy expansion (GENRE_EXPANSION)
 * 4. On-device session co-occurrences (LIBRARY_COOCCURRENCE)
 */
@Singleton
class CandidateAggregator @Inject constructor(
    private val youTubeRepository: YouTubeRepository,
    private val listenBrainzRepository: ListenBrainzRepository,
    private val musicRepository: MusicRepository,
    private val itemEmbeddingStore: ItemEmbeddingStore
) {

    companion object {
        private const val TAG = "CandidateAggregator"
    }

    suspend fun collect(
        seedSongs: List<Song>,
        limit: Int = 100
    ): List<RecommendationCandidate> = coroutineScope {
        if (seedSongs.isEmpty()) return@coroutineScope emptyList()

        val topSeeds = seedSongs.take(5)
        val ytDeferred = async { collectYouTubeRadioCandidates(topSeeds) }
        val lbDeferred = async { collectListenBrainzCandidates(topSeeds) }
        val genreDeferred = async { collectGenreCandidates(topSeeds) }
        val cooccurDeferred = async { collectCooccurrenceCandidates(topSeeds) }

        val ytCandidates = runCatching { ytDeferred.await() }
            .onFailure { Timber.tag(TAG).w(it, "YouTube candidate collection failed") }
            .getOrDefault(emptyList())

        val lbCandidates = runCatching { lbDeferred.await() }
            .onFailure { Timber.tag(TAG).w(it, "ListenBrainz candidate collection failed") }
            .getOrDefault(emptyList())

        val genreCandidates = runCatching { genreDeferred.await() }
            .onFailure { Timber.tag(TAG).w(it, "Genre candidate collection failed") }
            .getOrDefault(emptyList())

        val cooccurCandidates = runCatching { cooccurDeferred.await() }
            .onFailure { Timber.tag(TAG).w(it, "Cooccurrence candidate collection failed") }
            .getOrDefault(emptyList())

        val allCandidates = cooccurCandidates + ytCandidates + lbCandidates + genreCandidates
        deduplicateCandidates(allCandidates).take(limit)
    }

    private suspend fun collectCooccurrenceCandidates(seeds: List<Song>): List<RecommendationCandidate> {
        val results = mutableListOf<RecommendationCandidate>()
        for (seed in seeds.take(5)) {
            val similar = itemEmbeddingStore.getSimilarSongs(seed.id, limit = 5)
            if (similar.isNotEmpty()) {
                val neighborIds = similar.map { it.first }
                val neighborSongs = musicRepository.getSongsByIds(neighborIds)
                val scoreMap = similar.toMap()
                neighborSongs.forEach { song ->
                    results.add(
                        RecommendationCandidate(
                            song = song,
                            sourceType = CandidateSourceType.LIBRARY_COOCCURRENCE,
                            sourceStrength = scoreMap[song.id] ?: 0.75,
                            seedSongId = seed.id
                        )
                    )
                }
            }
        }
        return results
    }

    private suspend fun collectYouTubeRadioCandidates(seeds: List<Song>): List<RecommendationCandidate> {
        val results = mutableListOf<RecommendationCandidate>()
        for (seed in seeds.take(3)) {
            val radioTracks = runCatching { youTubeRepository.getRadioTracksForSong(seed) }.getOrDefault(emptyList())
            radioTracks.forEach { track ->
                results.add(
                    RecommendationCandidate(
                        song = track,
                        sourceType = CandidateSourceType.YT_RADIO,
                        sourceStrength = 0.85,
                        seedSongId = seed.id
                    )
                )
            }
        }
        return results
    }

    private suspend fun collectListenBrainzCandidates(seeds: List<Song>): List<RecommendationCandidate> {
        val results = mutableListOf<RecommendationCandidate>()
        for (seed in seeds) {
            val mbArtistId = seed.mbArtistId?.takeIf { it.isNotBlank() } ?: continue
            val similarArtists = runCatching { listenBrainzRepository.getSimilarArtists(mbArtistId) }.getOrDefault(emptyList())
            for (similar in similarArtists.take(3)) {
                val songs = runCatching { youTubeRepository.searchSongsPaginated(similar.name).songs }.getOrDefault(emptyList())
                songs.take(2).forEach { song ->
                    results.add(
                        RecommendationCandidate(
                            song = song,
                            sourceType = CandidateSourceType.LB_SIMILAR_ARTIST,
                            sourceStrength = similar.score.coerceIn(0.1, 1.0),
                            seedSongId = seed.id
                        )
                    )
                }
            }
        }
        return results
    }

    private suspend fun collectGenreCandidates(seeds: List<Song>): List<RecommendationCandidate> {
        val results = mutableListOf<RecommendationCandidate>()
        val knownFamilies = seeds.mapNotNull { it.genre?.let(GenreTaxonomy::familyOf) }.distinct()
        if (knownFamilies.isEmpty()) return results

        val allSongs = runCatching { musicRepository.getAllSongs() }.getOrDefault(emptyList())
        for (family in knownFamilies.take(2)) {
            val matchingSongs = allSongs.filter { it.genre?.let(GenreTaxonomy::familyOf) == family }
            matchingSongs.shuffled().take(5).forEach { song ->
                results.add(
                    RecommendationCandidate(
                        song = song,
                        sourceType = CandidateSourceType.GENRE_EXPANSION,
                        sourceStrength = 0.60,
                        seedSongId = null
                    )
                )
            }
        }
        return results
    }

    fun deduplicateCandidates(candidates: List<RecommendationCandidate>): List<RecommendationCandidate> {
        val deduplicated = linkedMapOf<String, RecommendationCandidate>()
        for (candidate in candidates) {
            val key = normalizeKey(candidate.song)
            val existing = deduplicated[key]
            if (existing == null || candidate.sourceStrength > existing.sourceStrength) {
                deduplicated[key] = candidate
            }
        }
        return deduplicated.values.toList()
    }

    private fun normalizeKey(song: Song): String {
        val mbid = song.mbRecordingId?.takeIf { it.isNotBlank() }
        if (mbid != null) return "mbid::$mbid"
        val ytid = song.youtubeId?.takeIf { it.isNotBlank() }
        if (ytid != null) return "yt::$ytid"
        return "norm::${song.title.trim().lowercase()}:::${song.artist.trim().lowercase()}"
    }
}
