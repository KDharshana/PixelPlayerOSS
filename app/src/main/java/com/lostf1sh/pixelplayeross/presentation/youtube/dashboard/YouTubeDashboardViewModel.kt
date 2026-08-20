package com.lostf1sh.pixelplayeross.presentation.youtube.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeBrowseSection
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

sealed interface YouTubeDashboardUiState {
    data object Loading : YouTubeDashboardUiState
    data class Success(
        val charts: List<Song>,
        val sections: List<InnertubeBrowseSection>
    ) : YouTubeDashboardUiState
    data class Error(val message: String) : YouTubeDashboardUiState
}

@HiltViewModel
class YouTubeDashboardViewModel @Inject constructor(
    private val youTubeRepository: YouTubeRepository
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
                        _uiState.value = YouTubeDashboardUiState.Success(
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
