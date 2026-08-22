package com.lostf1sh.pixelplayeross.data.recommendation

import com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity
import com.lostf1sh.pixelplayeross.data.model.Song
import java.util.Random
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stage 2 of recommendation engine: scores and ranks candidates through an on-device taste model,
 * and picks a diverse slice ensuring artist and genre variety.
 */
@Singleton
class PersonalizedRanker @Inject constructor() {

    data class RankingWeights(
        val affinityWeight: Double = 0.30,
        val sourceStrengthWeight: Double = 0.25,
        val recencyWeight: Double = 0.15,
        val favoriteWeight: Double = 0.15,
        val noveltyWeight: Double = 0.10,
        val completionBoostMultiplier: Double = 0.30,
        val skipPenaltyMultiplier: Double = 0.40
    )

    data class ScoredCandidate(
        val candidate: RecommendationCandidate,
        val finalScore: Double,
        val affinityScore: Double,
        val recencyScore: Double,
        val noveltyScore: Double,
        val favoriteScore: Double,
        val sourceStrengthScore: Double
    ) {
        val song: Song get() = candidate.song
    }

    data class DiversityState(
        val artistCounts: MutableMap<Long, Int> = mutableMapOf(),
        val genreCounts: MutableMap<String, Int> = mutableMapOf(),
        var unknownGenreCount: Int = 0
    )

    fun rank(
        candidates: List<RecommendationCandidate>,
        engagements: Map<String, SongEngagementEntity>,
        favoriteSongIds: Set<String>,
        weights: RankingWeights = RankingWeights(),
        random: Random = Random()
    ): List<ScoredCandidate> {
        if (candidates.isEmpty()) return emptyList()

        val now = System.currentTimeMillis()
        val maxPlayCount = engagements.values.maxOfOrNull { it.playCount }?.takeIf { it > 0 } ?: 1
        val maxDuration = engagements.values.maxOfOrNull { it.totalPlayDurationMs }?.takeIf { it > 0L } ?: 1L

        return candidates.map { candidate ->
            val song = candidate.song
            val stats = engagements[song.id]

            val playCountScore = (stats?.playCount?.toDouble() ?: 0.0) / maxPlayCount
            val durationScore = (stats?.totalPlayDurationMs?.toDouble() ?: 0.0) / maxDuration

            val completionBoost = if (stats != null && stats.playCount > 0) {
                (stats.completionCount.toDouble() / stats.playCount).coerceIn(0.0, 1.0)
            } else 0.0

            val totalPlaysAndSkips = (stats?.playCount ?: 0) + (stats?.skipBefore30sCount ?: 0)
            val skipPenalty = if (stats != null && totalPlaysAndSkips > 0) {
                (stats.skipBefore30sCount.toDouble() / totalPlaysAndSkips).coerceIn(0.0, 1.0)
            } else 0.0

            val rawAffinity = (playCountScore * 0.45 + durationScore * 0.25 + completionBoost * weights.completionBoostMultiplier - skipPenalty * weights.skipPenaltyMultiplier)
            val affinityScore = rawAffinity.coerceIn(0.0, 1.0)

            val recencyScore = computeRecencyScore(stats?.lastPlayedTimestamp, now)
            val noveltyScore = computeNoveltyScore(song.dateAdded, now)
            val favoriteScore = if (favoriteSongIds.contains(song.id)) 1.0 else 0.0
            val sourceStrengthScore = candidate.sourceStrength.coerceIn(0.0, 1.0)
            val baselineScore = if (stats == null) 0.05 else 0.0
            val noise = random.nextDouble() * 0.005

            val finalScore = (affinityScore * weights.affinityWeight) +
                (sourceStrengthScore * weights.sourceStrengthWeight) +
                (recencyScore * weights.recencyWeight) +
                (favoriteScore * weights.favoriteWeight) +
                (noveltyScore * weights.noveltyWeight) +
                baselineScore +
                noise

            ScoredCandidate(
                candidate = candidate,
                finalScore = if (finalScore.isNaN() || finalScore.isInfinite()) 0.0 else finalScore,
                affinityScore = affinityScore,
                recencyScore = recencyScore,
                noveltyScore = noveltyScore,
                favoriteScore = favoriteScore,
                sourceStrengthScore = sourceStrengthScore
            )
        }.sortedWith(compareByDescending<ScoredCandidate> { it.finalScore }.thenBy { it.song.id })
    }

    fun pickWithDiversity(
        rankedCandidates: List<ScoredCandidate>,
        favoriteSongIds: Set<String>,
        limit: Int,
        state: DiversityState = DiversityState()
    ): List<Song> {
        if (limit <= 0 || rankedCandidates.isEmpty()) return emptyList()

        val selected = mutableListOf<Song>()
        for (scored in rankedCandidates) {
            if (selected.size >= limit) break
            val song = scored.song
            val isFavorite = favoriteSongIds.contains(song.id)
            val maxPerArtist = if (isFavorite) 3 else 2
            val artistCount = state.artistCounts.getOrDefault(song.artistId, 0)
            if (artistCount >= maxPerArtist) continue

            selected += song
            state.artistCounts[song.artistId] = artistCount + 1
        }

        if (selected.size < limit) {
            val selectedIds = selected.mapTo(HashSet()) { it.id }
            for (scored in rankedCandidates) {
                if (selected.size >= limit) break
                if (scored.song.id in selectedIds) continue
                selected += scored.song
                selectedIds += scored.song.id
            }
        }

        return selected.take(limit)
    }

    private fun computeRecencyScore(lastPlayedTimestamp: Long?, now: Long): Double {
        if (lastPlayedTimestamp == null || lastPlayedTimestamp <= 0L) return 0.6
        val days = ((now - lastPlayedTimestamp).coerceAtLeast(0L) / TimeUnit.DAYS.toMillis(1)).toDouble()
        return when {
            days < 1 -> 0.2
            days < 3 -> 0.5
            days < 7 -> 0.7
            days < 14 -> 0.85
            else -> 1.0
        }
    }

    private fun computeNoveltyScore(dateAdded: Long, now: Long): Double {
        if (dateAdded <= 0L) return 0.0
        val dateAddedMillis = if (dateAdded < 10_000_000_000L) TimeUnit.SECONDS.toMillis(dateAdded) else dateAdded
        val days = ((now - dateAddedMillis).coerceAtLeast(0L) / TimeUnit.DAYS.toMillis(1)).toDouble()
        return (1.0 - (days / 60.0)).coerceIn(0.0, 1.0)
    }
}
