package com.lostf1sh.pixelplayeross.presentation.youtube.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lostf1sh.pixelplayeross.data.database.EngagementDao
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeBrowseSection
import com.lostf1sh.pixelplayeross.data.recommendation.AdaptiveWeightTuner
import com.lostf1sh.pixelplayeross.data.recommendation.CandidateAggregator
import com.lostf1sh.pixelplayeross.data.recommendation.PersonalizedRanker
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

sealed interface YouTubeDashboardUiState {
    data object Loading : YouTubeDashboardUiState
    data class Success(
        val forYou: List<Song>,
        val charts: List<Song>,
        val sections: List<InnertubeBrowseSection>
    ) : YouTubeDashboardUiState
    data class Error(val message: String) : YouTubeDashboardUiState
}

@HiltViewModel
class YouTubeDashboardViewModel @Inject constructor(
    private val youTubeRepository: YouTubeRepository,
    private val candidateAggregator: CandidateAggregator,
    private val personalizedRanker: PersonalizedRanker,
    private val adaptiveWeightTuner: AdaptiveWeightTuner,
    private val engagementDao: EngagementDao,
    private val musicRepository: MusicRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<YouTubeDashboardUiState>(YouTubeDashboardUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadDashboard()
    }

    fun loadDashboard() {
        viewModelScope.launch {
            _uiState.value = YouTubeDashboardUiState.Loading
            try {
                youTubeRepository.getExploreSections()
                    .catch { e ->
                        Timber.e(e, "Failed to load explore sections")
                        _uiState.value = YouTubeDashboardUiState.Error(e.message ?: "Failed to load Explore")
                    }
                    .collect { sections ->
                        val charts = sections.flatMap { it.tracks }.map { track ->
                            Song(
                                id = "youtube_${track.videoId}",
                                title = track.title,
                                artist = track.artist,
                                artistId = 0L,
                                album = track.album ?: "YouTube Music",
                                albumId = 0L,
                                albumArtist = track.artist,
                                path = "youtube://${track.videoId}",
                                contentUriString = "youtube://${track.videoId}",
                                albumArtUriString = track.thumbnailUri,
                                duration = track.durationSeconds * 1000L,
                                mimeType = "audio/webm",
                                bitrate = 160000,
                                sampleRate = 48000,
                                youtubeId = track.videoId
                            )
                        }

                        val forYou = withContext(Dispatchers.IO) {
                            runCatching {
                                val allEngagements = engagementDao.getAllEngagements()
                                if (allEngagements.size < 20) {
                                    charts.take(20)
                                } else {
                                    val topSongs = engagementDao.getTopPlayedSongs(10)
                                    val recentSongs = engagementDao.getRecentlyPlayedSongs(10)
                                    val seedIds = (topSongs + recentSongs).map { it.songId }.toSet()
                                    val allAudioSongs = musicRepository.getAudioFiles().first()
                                    val seedSongs = allAudioSongs.filter { it.id in seedIds }
                                    val candidates = candidateAggregator.collect(seedSongs, limit = 60)
                                    val engagementsMap = allEngagements.associateBy { it.songId }
                                    val tunedWeights = adaptiveWeightTuner.computeTunedWeights(allEngagements)
                                    val ranked = personalizedRanker.rank(
                                        candidates = candidates,
                                        engagements = engagementsMap,
                                        favoriteSongIds = emptySet(),
                                        weights = tunedWeights
                                    )
                                    val selected = personalizedRanker.pickWithDiversity(ranked, emptySet(), limit = 20)
                                    if (selected.isNotEmpty()) selected else charts.take(20)
                                }
                            }.getOrDefault(charts.take(20))
                        }

                        _uiState.value = YouTubeDashboardUiState.Success(
                            forYou = forYou,
                            charts = charts,
                            sections = sections
                        )
                    }
            } catch (e: Exception) {
                Timber.e(e, "Error initializing explore dashboard")
                _uiState.value = YouTubeDashboardUiState.Error(e.message ?: "Network error")
            }
        }
    }
}
