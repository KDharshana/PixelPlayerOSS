package com.lostf1sh.pixelplayeross.presentation.viewmodel

import com.google.common.truth.Truth.assertThat
import com.lostf1sh.pixelplayeross.data.database.EngagementDao
import com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity
import com.lostf1sh.pixelplayeross.data.model.SearchFilterType
import com.lostf1sh.pixelplayeross.data.model.SearchResultItem
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeSearchResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchStateHolderTest {

    private val testDispatcher = StandardTestDispatcher()
    private val musicRepository: MusicRepository = mockk(relaxed = true)
    private val youTubeRepository: YouTubeRepository = mockk(relaxed = true)
    private val engagementDao: EngagementDao = mockk(relaxed = true)

    private lateinit var searchStateHolder: SearchStateHolder

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        searchStateHolder = SearchStateHolder(
            musicRepository = musicRepository,
            youTubeRepository = youTubeRepository,
            engagementDao = engagementDao
        )
    }

    @AfterEach
    fun tearDown() {
        searchStateHolder.onCleared()
        Dispatchers.resetMain()
    }

    private fun buildSong(id: String, title: String, artist: String): Song = Song(
        id = id,
        title = title,
        artist = artist,
        artistId = 1L,
        album = "Album",
        albumId = 1L,
        path = "path/$id",
        contentUriString = "uri://$id",
        albumArtUriString = null,
        duration = 200000L,
        mimeType = "audio/mpeg",
        bitrate = 320000,
        sampleRate = 44100
    )

    @Test
    fun `search results are ordered by popularity high to low`() = runTest(testDispatcher) {
        val songLowPlay = buildSong("1", "Song Title", "Artist A")
        val songHighPlay = buildSong("2", "Song Title", "Artist B")

        val localResults = listOf(
            SearchResultItem.SongItem(songLowPlay),
            SearchResultItem.SongItem(songHighPlay)
        )

        coEvery { musicRepository.searchAll("Song", SearchFilterType.ALL) } returns flowOf(localResults)
        coEvery { youTubeRepository.searchAllPaginated("Song", SearchFilterType.ALL) } returns YouTubeSearchResult(emptyList(), null)
        coEvery { engagementDao.getAllEngagements() } returns listOf(
            SongEngagementEntity(
                songId = "1",
                playCount = 2,
                totalPlayDurationMs = 20000L,
                lastPlayedTimestamp = 1000L
            ),
            SongEngagementEntity(
                songId = "2",
                playCount = 50,
                totalPlayDurationMs = 500000L,
                lastPlayedTimestamp = 2000L,
                completionCount = 45
            )
        )

        searchStateHolder.initialize(this)
        searchStateHolder.performSearch("Song")
        advanceTimeBy(300L)

        val results = searchStateHolder.searchResults.value
        assertThat(results).hasSize(2)
        // High popularity song should be ranked first
        assertThat((results[0] as SearchResultItem.SongItem).song.id).isEqualTo("2")
        assertThat((results[1] as SearchResultItem.SongItem).song.id).isEqualTo("1")
    }
}
