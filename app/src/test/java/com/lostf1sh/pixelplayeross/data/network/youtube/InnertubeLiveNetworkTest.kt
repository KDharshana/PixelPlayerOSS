package com.lostf1sh.pixelplayeross.data.network.youtube

import com.lostf1sh.pixelplayeross.data.preferences.UserPreferencesRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test

class InnertubeLiveNetworkTest {

    @Test
    fun testLiveSearchAndStream() = runBlocking {
        val okHttpClient = OkHttpClient()
        val mockPrefs = mockk<UserPreferencesRepository>()
        every { mockPrefs.youTubeAuthCookiesFlow } returns flowOf(null)

        val apiService = InnertubeApiService(okHttpClient, mockPrefs, CoroutineScope(Dispatchers.IO))
        val extractorManager = YouTubeExtractorManager(okHttpClient)

        println("=== TESTING INNERTUBE SEARCH ===")
        val searchResult = apiService.search("Kotha Raja")
        println("Songs found: ${searchResult.songs.size}")
        searchResult.songs.take(5).forEach { song ->
            println(" - [${song.videoId}] title='${song.title}' artist='${song.artist}' album='${song.album}' duration=${song.durationSeconds}")
        }

        if (searchResult.songs.isNotEmpty()) {
            val firstVideoId = searchResult.songs.first().videoId
            println("\n=== TESTING NEWPIPE STREAM EXTRACTION for $firstVideoId ===")
            val newPipeUrl = extractorManager.extractAudioStreamUrl(firstVideoId)
            println("NewPipe Extracted Audio URL: $newPipeUrl")

            println("\n=== TESTING INNERTUBE STREAM INFO for $firstVideoId ===")
            val streamInfo = apiService.getStreamInfo(firstVideoId)
            println("Stream title: ${streamInfo?.title}")
            println("Stream format count: ${streamInfo?.formats?.size}")
        }

        println("\n=== TESTING INNERTUBE BROWSE ===")
        val sections = apiService.getBrowse()
        println("Browse sections found: ${sections.size}")
    }
}
