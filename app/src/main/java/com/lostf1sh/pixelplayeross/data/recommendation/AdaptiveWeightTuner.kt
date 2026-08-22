package com.lostf1sh.pixelplayeross.data.recommendation

import com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stage 3 of recommendation engine: on-device self-tuning module.
 * Evaluates user engagement telemetry (skip vs completion ratios) to dynamically adjust
 * ranking weights without transmitting any user data to external servers.
 */
@Singleton
class AdaptiveWeightTuner @Inject constructor() {

    /**
     * Analyzes engagement history and computes adaptive ranking weights.
     */
    fun computeTunedWeights(
        engagements: Collection<SongEngagementEntity>,
        baseWeights: PersonalizedRanker.RankingWeights = PersonalizedRanker.RankingWeights()
    ): PersonalizedRanker.RankingWeights {
        if (engagements.isEmpty()) return baseWeights

        val totalPlays = engagements.sumOf { it.playCount }
        val totalSkips = engagements.sumOf { it.skipBefore30sCount }
        val totalCompletions = engagements.sumOf { it.completionCount }

        val totalInteractions = (totalPlays + totalSkips).coerceAtLeast(1)
        val skipRate = totalSkips.toDouble() / totalInteractions
        val completionRate = totalCompletions.toDouble() / totalInteractions

        var affinityWeight = baseWeights.affinityWeight
        var sourceStrengthWeight = baseWeights.sourceStrengthWeight
        var recencyWeight = baseWeights.recencyWeight
        var skipPenaltyMultiplier = baseWeights.skipPenaltyMultiplier
        var completionBoostMultiplier = baseWeights.completionBoostMultiplier

        // High skip rate (> 30%): increase skip penalty and diversify away from repeated plays
        if (skipRate > 0.30) {
            val penaltyFactor = (skipRate - 0.30) * 1.5
            skipPenaltyMultiplier = (baseWeights.skipPenaltyMultiplier + penaltyFactor).coerceAtMost(0.80)
            recencyWeight = (baseWeights.recencyWeight + 0.05).coerceAtMost(0.30)
            sourceStrengthWeight = (baseWeights.sourceStrengthWeight + 0.05).coerceAtMost(0.35)
            affinityWeight = (baseWeights.affinityWeight - 0.10).coerceAtLeast(0.15)
        }

        // High completion rate (> 60%): user is satisfied with current taste graph, exploit affinity
        if (completionRate > 0.60) {
            val boostFactor = (completionRate - 0.60) * 1.0
            completionBoostMultiplier = (baseWeights.completionBoostMultiplier + boostFactor).coerceAtMost(0.60)
            affinityWeight = (affinityWeight + 0.05).coerceAtMost(0.45)
        }

        return baseWeights.copy(
            affinityWeight = affinityWeight,
            sourceStrengthWeight = sourceStrengthWeight,
            recencyWeight = recencyWeight,
            skipPenaltyMultiplier = skipPenaltyMultiplier,
            completionBoostMultiplier = completionBoostMultiplier
        )
    }
}
