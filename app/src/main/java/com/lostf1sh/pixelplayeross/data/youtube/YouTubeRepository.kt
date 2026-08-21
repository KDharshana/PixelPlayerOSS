package com.lostf1sh.pixelplayeross.data.youtube

import com.lostf1sh.pixelplayeross.data.database.YouTubeDao
import com.lostf1sh.pixelplayeross.data.database.YouTubePlaylistEntity
import com.lostf1sh.pixelplayeross.data.database.YouTubeSongEntity
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeApiService
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeBrowseSection
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeSearchResult
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeTrack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository orchestrating YouTube Music search, charts, streaming resolution,
 * and local library caching.
 */
@Singleton
class YouTubeRepository @Inject constructor(
    private val innertubeApiService: InnertubeApiService,
    private val youTubeExtractorManager: com.lostf1sh.pixelplayeross.data.network.youtube.YouTubeExtractorManager,
    private val youTubeDao: YouTubeDao
) {
    private companion object {
        private const val TAG = "YouTubeRepository"
    }

    /**
     * Observes all locally cached / synced YouTube Music songs from the database.
     */
    val cachedSongsFlow: Flow<List<Song>> = youTubeDao.getAllYouTubeSongs().map { entities ->
        entities.map { it.toSong() }
    }.flowOn(Dispatchers.IO)

    /**
     * Observes all synced YouTube Music playlists from the database.
     */
    val playlistsFlow: Flow<List<YouTubePlaylistEntity>> = youTubeDao.getAllPlaylists()
        .flowOn(Dispatchers.IO)

    data class YouTubePageResult(
        val songs: List<Song>,
        val continuationToken: String?
    )

    /**
     * Searches YouTube Music for songs matching the query with continuation support.
     */
    suspend fun searchSongsPaginated(query: String, continuation: String? = null): YouTubePageResult = withContext(Dispatchers.IO) {
        if (query.isBlank() && continuation.isNullOrBlank()) {
            return@withContext YouTubePageResult(emptyList(), null)
        }
        val result = innertubeApiService.search(query, continuation)
        val songs = result.songs.map { it.toDomainSong() }
        YouTubePageResult(songs, result.continuationToken)
    }

    /**
     * Searches YouTube Music for songs matching the query.
     */
    fun searchSongs(query: String): Flow<List<Song>> = flow {
        if (query.isBlank()) {
            emit(emptyList())
            return@flow
        }
        val result = innertubeApiService.search(query)
        val songs = result.songs.map { it.toDomainSong() }
        emit(songs)
    }.flowOn(Dispatchers.IO)

    /**
     * Fetches top charts / trending music tracks.
     */
    fun getCharts(): Flow<List<Song>> = flow {
        val sections = innertubeApiService.getBrowse("FEmusic_charts")
        val tracks = sections.flatMap { it.tracks }.map { it.toDomainSong() }
        emit(tracks)
    }.flowOn(Dispatchers.IO)

    /**
     * Fetches browse sections for the Explore/Discover screen.
     */
    fun getExploreSections(): Flow<List<InnertubeBrowseSection>> = flow {
        val sections = innertubeApiService.getBrowse("FEmusic_home")
        emit(sections)
    }.flowOn(Dispatchers.IO)

    /**
     * Resolves the direct audio stream URL for a given YouTube video ID.
     */
    suspend fun getStreamUrl(videoId: String): String? = withContext(Dispatchers.IO) {
        val extractedUrl = runCatching { youTubeExtractorManager.extractAudioStreamUrl(videoId) }.getOrNull()
        if (!extractedUrl.isNullOrBlank()) {
            return@withContext extractedUrl
        }
        val streamInfo = runCatching { innertubeApiService.getStreamInfo(videoId) }.getOrNull()
        streamInfo?.selectedFormatUrl ?: streamInfo?.highestBitrateOpusUrl ?: streamInfo?.highestBitrateAacUrl
    }

    /**
     * Fetches timestamped lyrics for a track if available.
     */
    suspend fun getLyrics(videoId: String): String? = withContext(Dispatchers.IO) {
        innertubeApiService.getTranscriptLyrics(videoId)
    }

    /**
     * Fetches radio / autoplay recommended tracks for a given YouTube video ID.
     */
    suspend fun getRadioTracks(videoId: String): List<Song> = withContext(Dispatchers.IO) {
        val tracks = innertubeApiService.getRadioTracks(videoId)
        tracks.map { it.toDomainSong() }
    }

    /**
     * Fetches radio / autoplay tracks for any song (local or online).
     */
    suspend fun getRadioTracksForSong(song: Song): List<Song> = withContext(Dispatchers.IO) {
        val videoId = song.youtubeId
            ?: song.contentUriString.takeIf { it.startsWith("youtube://") }?.removePrefix("youtube://")
            ?: run {
                val searchResult = innertubeApiService.search("${song.title} ${song.artist}")
                searchResult.songs.firstOrNull()?.videoId
            }

        if (videoId.isNullOrBlank()) return@withContext emptyList()
        getRadioTracks(videoId)
    }

    /**
     * Saves a YouTube Music track to the local database library.
     */
    suspend fun saveTrackToLibrary(song: Song) = withContext(Dispatchers.IO) {
        val videoId = song.youtubeId ?: song.contentUriString.removePrefix("youtube://")
        val entity = YouTubeSongEntity(
            id = song.id,
            videoId = videoId,
            playlistId = "__library__",
            title = song.title,
            artist = song.artist,
            album = song.album,
            duration = song.duration,
            thumbnailUrl = song.albumArtUriString,
            year = song.year,
            dateAdded = System.currentTimeMillis()
        )
        youTubeDao.insertSong(entity)
    }

    /**
     * Removes a track from the local cached YouTube library.
     */
    suspend fun removeTrackFromLibrary(songId: String) = withContext(Dispatchers.IO) {
        youTubeDao.deleteSong(songId)
    }

    private fun InnertubeTrack.toDomainSong(): Song {
        return Song(
            id = "youtube_$videoId",
            title = title,
            artist = artist,
            artistId = 0L,
            album = album ?: "YouTube Music",
            albumId = 0L,
            albumArtist = artist,
            path = "youtube://$videoId",
            contentUriString = "youtube://$videoId",
            albumArtUriString = thumbnailUri,
            duration = durationSeconds * 1000L,
            mimeType = "audio/webm",
            bitrate = 160000,
            sampleRate = 48000,
            youtubeId = videoId
        )
    }
}
