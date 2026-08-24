package com.quietrays.tonarc.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quietrays.tonarc.data.model.Song
import com.quietrays.tonarc.data.preferences.UserPreferencesRepository
import com.quietrays.tonarc.data.repository.ArtistImageRepository
import com.quietrays.tonarc.data.repository.MusicRepository
import com.quietrays.tonarc.data.youtube.YouTubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

data class FavoriteArtistSongsUiState(
    val artistName: String = "",
    val artistImageUrl: String? = null,
    val songs: List<Song> = emptyList(),
    val isFavorite: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)

@HiltViewModel
class FavoriteArtistSongsViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val youTubeRepository: YouTubeRepository,
    private val artistImageRepository: ArtistImageRepository,
    private val userPreferencesRepository: UserPreferencesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val rawArtistName: String = savedStateHandle.get<String>("artistName")?.let {
        runCatching { java.net.URLDecoder.decode(it, "UTF-8") }.getOrDefault(it)
    } ?: ""

    private val _uiState = MutableStateFlow(FavoriteArtistSongsUiState(artistName = rawArtistName))
    val uiState: StateFlow<FavoriteArtistSongsUiState> = _uiState.asStateFlow()

    init {
        observeFavoriteStatus()
        loadArtistSongs(rawArtistName)
    }

    private fun observeFavoriteStatus() {
        userPreferencesRepository.favoriteArtistsFlow
            .onEach { favSet ->
                _uiState.update { it.copy(isFavorite = favSet.contains(rawArtistName)) }
            }
            .launchIn(viewModelScope)
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            if (rawArtistName.isNotBlank()) {
                userPreferencesRepository.toggleFavoriteArtist(rawArtistName)
            }
        }
    }

    fun loadArtistSongs(artistName: String, forceRefresh: Boolean = false) {
        if (artistName.isBlank()) {
            _uiState.update { it.copy(isLoading = false, errorMessage = "Invalid artist name") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                // 1. Fetch artist image
                val artistImage: String? = runCatching {
                    artistImageRepository.getArtistImageUrl(artistName, 0L)
                }.getOrNull()

                // 2. Fetch local matching songs
                val localSongs = runCatching {
                    musicRepository.getAudioFiles().first()
                }.getOrDefault(emptyList()).filter { song ->
                    song.artist.equals(artistName, ignoreCase = true) ||
                        song.artists.any { it.name.equals(artistName, ignoreCase = true) } ||
                        song.artist.contains(artistName, ignoreCase = true)
                }

                // 3. Fetch online songs from YouTube Music
                val onlineSongs = runCatching {
                    youTubeRepository.searchSongsPaginated(artistName).songs
                }.getOrDefault(emptyList())

                // 4. Combine & deduplicate songs (local priority, followed by online)
                val allSongs = (localSongs + onlineSongs).distinctBy { it.id }

                val resolvedImage = artistImage
                    ?: allSongs.firstOrNull { !it.albumArtUriString.isNullOrBlank() }?.albumArtUriString

                _uiState.update {
                    it.copy(
                        artistName = artistName,
                        artistImageUrl = resolvedImage,
                        songs = allSongs,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Timber.tag("FavArtistSongsVM").e(e, "Failed to load songs for artist %s", artistName)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.localizedMessage ?: "Failed to load artist songs"
                    )
                }
            }
        }
    }
}
