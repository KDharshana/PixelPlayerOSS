package com.quietrays.tonarc.data.recommendation

import com.quietrays.tonarc.data.database.ItemCooccurrenceDao
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
            val safeMaxCount = if (maxCount <= 0.0 || maxCount.isNaN() || maxCount.isInfinite()) 1.0 else maxCount

            rows.mapNotNull { row ->
                val neighborId = if (row.songIdA == safeId) row.songIdB else row.songIdA
                if (neighborId == safeId) null
                else {
                    // Strictly normalized score in [0.0, 1.0] based on relative edge weight
                    val rawScore = row.cooccurrenceCount.toDouble() / safeMaxCount
                    val normalizedScore = if (rawScore.isNaN() || rawScore.isInfinite()) 0.0 else rawScore.coerceIn(0.0, 1.0)
                    Pair(neighborId, normalizedScore)
                }
            }.take(limit)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Failed to query similar songs for %s", safeId)
            emptyList()
        }
    }

    /**
     * Calculates cosine similarity between two dense float embedding vectors.
     * Guaranteed safe against zero divisor, NaN, and infinity edge cases with `if (norm == 0f) 0f else dot / norm`.
     */
    fun cosineSimilarity(vecA: FloatArray, vecB: FloatArray): Float {
        if (vecA.isEmpty() || vecB.isEmpty() || vecA.size != vecB.size) return 0f
        var dot = 0f
        var normA = 0f
        var normB = 0f
        for (i in vecA.indices) {
            val a = vecA[i]
            val b = vecB[i]
            if (a.isNaN() || b.isNaN() || a.isInfinite() || b.isInfinite()) continue
            dot += a * b
            normA += a * a
            normB += b * b
        }
        val norm = sqrt(normA * normB)
        return if (norm == 0f || norm.isNaN() || norm.isInfinite()) 0f else (dot / norm).coerceIn(0f, 1f)
    }

    /**
     * Calculates cosine similarity between two sparse double embedding vectors.
     * Guaranteed safe against zero divisor, NaN, and infinity edge cases.
     */
    fun cosineSimilarity(vecA: Map<String, Double>, vecB: Map<String, Double>): Double {
        if (vecA.isEmpty() || vecB.isEmpty()) return 0.0
        var dot = 0.0
        var normA = 0.0
        var normB = 0.0
        for ((key, a) in vecA) {
            if (a.isNaN() || a.isInfinite()) continue
            normA += a * a
            val b = vecB[key] ?: continue
            if (b.isNaN() || b.isInfinite()) continue
            dot += a * b
        }
        for ((_, b) in vecB) {
            if (b.isNaN() || b.isInfinite()) continue
            normB += b * b
        }
        val norm = sqrt(normA * normB)
        return if (norm == 0.0 || norm.isNaN() || norm.isInfinite()) 0.0 else (dot / norm).coerceIn(0.0, 1.0)
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
