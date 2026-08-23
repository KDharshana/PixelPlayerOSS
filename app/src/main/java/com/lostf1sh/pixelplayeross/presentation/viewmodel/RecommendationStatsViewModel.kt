package com.lostf1sh.pixelplayeross.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.lostf1sh.pixelplayeross.data.database.EngagementDao
import com.lostf1sh.pixelplayeross.data.database.ItemCooccurrenceDao
import com.lostf1sh.pixelplayeross.data.database.ItemCooccurrenceEntity
import com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.recommendation.AdaptiveWeightTuner
import com.lostf1sh.pixelplayeross.data.recommendation.PersonalizedRanker
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.worker.RecommendationWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class EnrichedEngagement(
    val entity: SongEngagementEntity,
    val song: Song?
)

data class RecommendationStatsUiState(
    val isLoading: Boolean = true,
    val totalSongsTracked: Int = 0,
    val totalPlays: Int = 0,
    val totalCompletions: Int = 0,
    val totalSkips: Int = 0,
    val totalRepeats: Int = 0,
    val completionRatePct: Double = 0.0,
    val skipRatePct: Double = 0.0,
    val totalCooccurrenceEdges: Int = 0,
    val tunedWeights: PersonalizedRanker.RankingWeights = PersonalizedRanker.RankingWeights(),
    val topEngagedSongs: List<EnrichedEngagement> = emptyList(),
    val topCooccurrences: List<ItemCooccurrenceEntity> = emptyList(),
    val allSongs: List<Song> = emptyList(),
    val message: String? = null
)

@HiltViewModel
class RecommendationStatsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val engagementDao: EngagementDao,
    private val itemCooccurrenceDao: ItemCooccurrenceDao,
    private val adaptiveWeightTuner: AdaptiveWeightTuner,
    private val musicRepository: MusicRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecommendationStatsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadStats()
    }

    fun loadStats() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            withContext(Dispatchers.IO) {
                val allEngagements = engagementDao.getAllEngagements()
                val allSongs = runCatching { musicRepository.getAudioFiles().first() }.getOrDefault(emptyList())
                val songsMap = allSongs.associateBy { it.id }

                val totalPlays = allEngagements.sumOf { it.playCount }
                val totalCompletions = allEngagements.sumOf { it.completionCount }
                val totalSkips = allEngagements.sumOf { it.skipBefore30sCount }
                val totalRepeats = allEngagements.sumOf { it.sessionRepeatCount }

                val totalOutcomes = totalCompletions + totalSkips
                val completionRate = if (totalOutcomes > 0) (totalCompletions.toDouble() / totalOutcomes) * 100.0 else 0.0
                val skipRate = if (totalOutcomes > 0) (totalSkips.toDouble() / totalOutcomes) * 100.0 else 0.0

                val edgeCount = runCatching { itemCooccurrenceDao.getEdgeCount() }.getOrDefault(0)
                val topEdges = runCatching { itemCooccurrenceDao.getTopCooccurrences(15) }.getOrDefault(emptyList())

                val tuned = adaptiveWeightTuner.computeTunedWeights(allEngagements)

                val topRaw = allEngagements.sortedByDescending { it.playCount + it.completionCount }.take(25)
                val enriched = topRaw.map { entity ->
                    EnrichedEngagement(
                        entity = entity,
                        song = songsMap[entity.songId]
                    )
                }

                _uiState.value = RecommendationStatsUiState(
                    isLoading = false,
                    totalSongsTracked = allEngagements.size,
                    totalPlays = totalPlays,
                    totalCompletions = totalCompletions,
                    totalSkips = totalSkips,
                    totalRepeats = totalRepeats,
                    completionRatePct = completionRate,
                    skipRatePct = skipRate,
                    totalCooccurrenceEdges = edgeCount,
                    tunedWeights = tuned,
                    topEngagedSongs = enriched,
                    topCooccurrences = topEdges,
                    allSongs = allSongs
                )
            }
        }
    }

    fun simulatePlay(songId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            engagementDao.recordPlay(songId, 180000L, now)
            loadStats()
        }
    }

    fun simulateCompletion(songId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            engagementDao.recordCompletion(songId, now)
            loadStats()
        }
    }

    fun simulateSkip(songId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            engagementDao.recordSkip(songId, now)
            loadStats()
        }
    }

    fun simulateRepeat(songId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            engagementDao.recordSessionRepeat(songId, "diag_session_${now}", now)
            loadStats()
        }
    }

    fun simulatePairwisePlay(songA: String, songB: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            val (k1, k2) = if (songA < songB) songA to songB else songB to songA
            itemCooccurrenceDao.incrementCooccurrence(k1, k2, now)
            loadStats()
        }
    }

    fun clearAllTelemetry() {
        viewModelScope.launch(Dispatchers.IO) {
            engagementDao.clearAllEngagements()
            itemCooccurrenceDao.clearAll()
            loadStats()
        }
    }

    fun triggerWorkerNow() {
        val request = OneTimeWorkRequestBuilder<RecommendationWorker>().build()
        WorkManager.getInstance(context).enqueue(request)
        _uiState.value = _uiState.value.copy(message = "RecommendationWorker triggered in background")
    }

    fun clearMessage() {
        _uiState.value = _uiState.value.copy(message = null)
    }
}
