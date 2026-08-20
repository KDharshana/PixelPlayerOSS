package com.lostf1sh.pixelplayeross.presentation.youtube.auth

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lostf1sh.pixelplayeross.ui.theme.PixelPlayerTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class YouTubeLoginActivity : ComponentActivity() {

    private val viewModel: YouTubeLoginViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PixelPlayerTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                var isLoading by remember { mutableStateOf(true) }

                LaunchedEffect(uiState) {
                    if (uiState is YouTubeLoginUiState.Success) {
                        setResult(Activity.RESULT_OK)
                        finish()
                    }
                }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Sign in to YouTube Music") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            )
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        YouTubeLoginWebView(
                            onPageLoadingChanged = { loading -> isLoading = loading },
                            onCookiesDetected = { cookies ->
                                viewModel.onCookiesCaptured(cookies)
                            }
                        )

                        if (isLoading || uiState is YouTubeLoginUiState.LoggingIn) {
                            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun YouTubeLoginWebView(
    onPageLoadingChanged: (Boolean) -> Unit,
    onCookiesDetected: (String) -> Unit
) {
    AndroidView(
        factory = { ctx ->
            WebView(ctx).apply {
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    databaseEnabled = true
                    mixedContentMode = WebSettings.MIXED_CONTENT_NEVER_ALLOW
                    userAgentString = "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36"
                }

                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        onPageLoadingChanged(false)

                        val cookieManager = CookieManager.getInstance()
                        val musicCookies = cookieManager.getCookie("https://music.youtube.com") ?: ""
                        val ytCookies = cookieManager.getCookie("https://youtube.com") ?: ""
                        val googleCookies = cookieManager.getCookie("https://accounts.google.com") ?: ""
                        val currentCookies = url?.let { cookieManager.getCookie(it) } ?: ""

                        val allCookieMap = mutableMapOf<String, String>()
                        listOf(googleCookies, ytCookies, musicCookies, currentCookies).forEach { cookieStr ->
                            cookieStr.split(";").forEach { pair ->
                                val trimmed = pair.trim()
                                val key = trimmed.substringBefore("=").trim()
                                val value = trimmed.substringAfter("=", "").trim()
                                if (key.isNotEmpty() && value.isNotEmpty()) {
                                    allCookieMap[key] = value
                                }
                            }
                        }
                        val combinedCookies = allCookieMap.entries.joinToString("; ") { "${it.key}=${it.value}" }
                        if (allCookieMap.containsKey("SAPISID") || allCookieMap.containsKey("__Secure-3PAPISID") || allCookieMap.containsKey("__Secure-1PAPISID") || allCookieMap.containsKey("LOGIN_INFO")) {
                            android.util.Log.d("YouTubeMusic", "YouTube Music login cookies captured successfully! Keys: ${allCookieMap.keys}")
                            onCookiesDetected(combinedCookies)
                        }
                    }
                }

                loadUrl("https://accounts.google.com/ServiceLogin?service=youtube&continue=https://music.youtube.com")
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
