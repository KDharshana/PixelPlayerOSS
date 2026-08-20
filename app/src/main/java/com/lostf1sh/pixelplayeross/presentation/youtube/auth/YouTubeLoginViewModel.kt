package com.lostf1sh.pixelplayeross.presentation.youtube.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeApiService
import com.lostf1sh.pixelplayeross.data.preferences.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

sealed interface YouTubeLoginUiState {
    data object Idle : YouTubeLoginUiState
    data object LoggingIn : YouTubeLoginUiState
    data class Success(val accountName: String) : YouTubeLoginUiState
    data class Error(val message: String) : YouTubeLoginUiState
}

@HiltViewModel
class YouTubeLoginViewModel @Inject constructor(
    private val innertubeApiService: InnertubeApiService,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<YouTubeLoginUiState>(YouTubeLoginUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun onCookiesCaptured(cookies: String) {
        if (cookies.isBlank()) return

        viewModelScope.launch {
            _uiState.value = YouTubeLoginUiState.LoggingIn
            try {
                // Apply cookies to api service
                innertubeApiService.authCookies = cookies
                // Save cookies in preferences
                userPreferencesRepository.setYouTubeAuthCookies(cookies)
                _uiState.value = YouTubeLoginUiState.Success("YouTube Music Connected")
            } catch (e: Exception) {
                Timber.e(e, "Failed to save YouTube auth cookies")
                _uiState.value = YouTubeLoginUiState.Error(e.message ?: "Authentication failed")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            innertubeApiService.authCookies = null
            userPreferencesRepository.setYouTubeAuthCookies(null)
            _uiState.value = YouTubeLoginUiState.Idle
        }
    }
}
