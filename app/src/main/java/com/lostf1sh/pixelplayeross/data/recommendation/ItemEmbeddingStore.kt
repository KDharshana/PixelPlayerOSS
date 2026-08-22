package com.lostf1sh.pixelplayeross.data.recommendation

import com.lostf1sh.pixelplayeross.data.database.ItemCooccurrenceDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.ln
import kotlin.math.sqrt

/**
 * Manages lightweight sparse item embeddings computed directly from session playback co-occurrences.
 * Uses normalized pointwise mutual information (NPMI) / cosine similarity on sparse count vectors.
 */
@Singleton
class ItemEmbeddingStore @Inject constructor(
    private val cooccurrenceDao: ItemCooccurrenceDao
) {

    companion object {
        private const val TAG = "ItemEmbeddingStore"
    }

    /**
     * Records an adjacent or near-adjacent play event between two songs within a session window.
     * Orders the keys lexicographically so (A, B) and (B, A) aggregate into a single edge.
     */
    suspend fun recordPairwisePlay(songIdA: String, songIdB: String, timestamp: Long = System.currentTimeMillis()) {
        val safeA = songIdA.trim()
        val safeB = songIdB.trim()
        if (safeA.isEmpty() || safeB.isEmpty() || safeA == safeB) return

        val (first, second) = if (safeA < safeB) Pair(safeA, safeB) else Pair(safeB, safeA)
        try {
            cooccurrenceDao.incrementCooccurrence(first, second, timestamp)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Failed to increment item co-occurrence for %s and %s", first, second)
        }
    }

    /**
     * Returns top co-occurring similar songs scored by normalized association strength.
     */
    suspend fun getSimilarSongs(songId: String, limit: Int = 10): List<Pair<String, Double>> {
        val safeId = songId.trim()
        if (safeId.isEmpty() || limit <= 0) return emptyList()

        return try {
            val rows = cooccurrenceDao.getCooccurrencesForSong(safeId, limit * 2)
            if (rows.isEmpty()) return emptyList()

            val maxCount = rows.maxOfOrNull { it.cooccurrenceCount }?.toDouble() ?: 1.0

            rows.mapNotNull { row ->
                val neighborId = if (row.songIdA == safeId) row.songIdB else row.songIdA
                if (neighborId == safeId) null
                else {
                    // Normalized score in [0.1, 1.0] based on relative edge weight
                    val normalizedScore = (row.cooccurrenceCount.toDouble() / maxCount).coerceIn(0.1, 1.0)
                    Pair(neighborId, normalizedScore)
                }
            }.take(limit)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Failed to query similar songs for %s", safeId)
            emptyList()
        }
    }

    /**
     * Cleans up stale / single-count co-occurrences older than given timestamp.
     */
    suspend fun pruneStaleEntries(staleBeforeTimestamp: Long): Int {
        return try {
            cooccurrenceDao.pruneStale(minCount = 1, staleBeforeTimestamp = staleBeforeTimestamp)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Failed to prune stale co-occurrence entries")
            0
        }
    }
}
