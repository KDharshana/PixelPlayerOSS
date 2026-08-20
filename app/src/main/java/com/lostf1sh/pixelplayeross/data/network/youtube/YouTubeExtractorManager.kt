package com.lostf1sh.pixelplayeross.data.network.youtube

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.ServiceList
import org.schabi.newpipe.extractor.stream.StreamInfo
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages audio stream extraction using NewPipeExtractor with automated n-sig & cipher deobfuscation.
 */
@Singleton
class YouTubeExtractorManager @Inject constructor(
    private val okHttpClient: OkHttpClient
) {
    private val isInitialized = AtomicBoolean(false)

    private fun ensureInitialized() {
        if (isInitialized.compareAndSet(false, true)) {
            try {
                NewPipe.init(NewPipeDownloader(okHttpClient))
                android.util.Log.d("YouTubeMusic", "NewPipeExtractor initialized successfully")
            } catch (e: Exception) {
                android.util.Log.e("YouTubeMusic", "Failed to initialize NewPipeExtractor", e)
            }
        }
    }

    /**
     * Resolves the direct audio stream URL for a given YouTube video ID.
     */
    suspend fun extractAudioStreamUrl(videoId: String): String? = withContext(Dispatchers.IO) {
        ensureInitialized()
        try {
            android.util.Log.d("YouTubeMusic", "Extracting stream with NewPipeExtractor for videoId: $videoId")
            val watchUrl = "https://www.youtube.com/watch?v=$videoId"
            val streamInfo = StreamInfo.getInfo(ServiceList.YouTube, watchUrl)
            val audioStreams = streamInfo.audioStreams

            android.util.Log.d("YouTubeMusic", "NewPipeExtractor found ${audioStreams.size} audio streams for $videoId")

            // Prefer highest bitrate Opus, then AAC
            val selectedStream = audioStreams
                .filter { !it.content.isNullOrBlank() }
                .maxByOrNull { it.averageBitrate }
                ?: audioStreams.firstOrNull { !it.content.isNullOrBlank() }

            val resolvedUrl = selectedStream?.content
            android.util.Log.d("YouTubeMusic", "NewPipeExtractor resolved stream url: ${resolvedUrl != null} (format=${selectedStream?.format?.name}, bitrate=${selectedStream?.averageBitrate})")
            resolvedUrl
        } catch (e: Exception) {
            android.util.Log.e("YouTubeMusic", "NewPipeExtractor failed for videoId: $videoId", e)
            null
        }
    }
}
