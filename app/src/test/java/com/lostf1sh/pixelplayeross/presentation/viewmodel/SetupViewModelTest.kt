package com.lostf1sh.pixelplayeross.presentation.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.lostf1sh.pixelplayeross.data.backup.BackupManager
import com.lostf1sh.pixelplayeross.data.model.SearchResultItem
import com.lostf1sh.pixelplayeross.data.model.Artist
import com.lostf1sh.pixelplayeross.data.preferences.ThemePreferencesRepository
import com.lostf1sh.pixelplayeross.data.preferences.UserPreferencesRepository
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.worker.SyncManager
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.Files

@OptIn(ExperimentalCoroutinesApi::class)
class SetupViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var userPreferencesRepository: UserPreferencesRepository
    private lateinit var themePreferencesRepository: ThemePreferencesRepository
    private lateinit var syncManager: SyncManager
    private lateinit var backupManager: BackupManager
    private lateinit var musicRepository: MusicRepository
    private lateinit var youTubeRepository: YouTubeRepository
    private lateinit var context: Context
    private lateinit var tempDir: java.nio.file.Path

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        tempDir = Files.createTempDirectory("setup-vm-test")
        userPreferencesRepository = UserPreferencesRepository(
            dataStore = PreferenceDataStoreFactory.create(
                scope = kotlinx.coroutines.CoroutineScope(testDispatcher),
                produceFile = { tempDir.resolve("settings.preferences_pb").toFile() }
            ),
            json = Json
        )
        themePreferencesRepository = mockk(relaxed = true)
        syncManager = mockk(relaxed = true) {
            coEvery { isSyncing } returns flowOf(false)
        }
        backupManager = mockk(relaxed = true)
        musicRepository = mockk(relaxed = true)
        youTubeRepository = mockk(relaxed = true)
        context = mockk(relaxed = true)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        tempDir.toFile().deleteRecursively()
    }

    private fun createViewModel(): SetupViewModel {
        return SetupViewModel(
            userPreferencesRepository = userPreferencesRepository,
            themePreferencesRepository = themePreferencesRepository,
            syncManager = syncManager,
            backupManager = backupManager,
            musicRepository = musicRepository,
            youTubeRepository = youTubeRepository,
            context = context
        )
    }

    @Test
    fun `toggleFavoriteArtist adds and removes artist correctly`() = runTest(testDispatcher) {
        val viewModel = createViewModel()
        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.uiState.value.selectedFavoriteArtists.isEmpty())

        viewModel.toggleFavoriteArtist("Taylor Swift")
        assertTrue(viewModel.uiState.value.selectedFavoriteArtists.contains("Taylor Swift"))
        assertEquals(1, viewModel.uiState.value.selectedFavoriteArtists.size)

        viewModel.toggleFavoriteArtist("The Weeknd")
        assertEquals(2, viewModel.uiState.value.selectedFavoriteArtists.size)

        viewModel.toggleFavoriteArtist("Taylor Swift")
        assertFalse(viewModel.uiState.value.selectedFavoriteArtists.contains("Taylor Swift"))
        assertEquals(1, viewModel.uiState.value.selectedFavoriteArtists.size)
    }

    @Test
    fun `minimum 5 favorite artists validation`() = runTest(testDispatcher) {
        val viewModel = createViewModel()
        testDispatcher.scheduler.advanceUntilIdle()

        assertFalse(viewModel.uiState.value.hasMinimumFavoriteArtists)

        val artists = listOf("Taylor Swift", "The Weeknd", "Billie Eilish", "Coldplay", "Eminem")
        artists.take(4).forEach { viewModel.toggleFavoriteArtist(it) }
        assertFalse(viewModel.uiState.value.hasMinimumFavoriteArtists)

        viewModel.toggleFavoriteArtist(artists[4])
        assertTrue(viewModel.uiState.value.hasMinimumFavoriteArtists)
    }

    @Test
    fun `saveFavoriteArtists writes selected artists to repository`() = runTest(testDispatcher) {
        val viewModel = createViewModel()
        testDispatcher.scheduler.advanceUntilIdle()

        val artists = setOf("Taylor Swift", "The Weeknd", "Billie Eilish", "Coldplay", "Eminem")
        artists.forEach { viewModel.toggleFavoriteArtist(it) }
        viewModel.saveFavoriteArtists()
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(artists, userPreferencesRepository.favoriteArtistsFlow.first())
    }

    @Test
    fun `searchArtists updates query and fetches results`() = runTest(testDispatcher) {
        coEvery {
            youTubeRepository.searchAllPaginated(query = "Dua", filterType = com.lostf1sh.pixelplayeross.data.model.SearchFilterType.ARTISTS)
        } returns YouTubeRepository.YouTubeMultiPageResult(
            items = listOf(
                SearchResultItem.ArtistItem(
                    Artist(id = 1L, name = "Dua Lipa", songCount = 50, imageUrl = "https://img/dualipa.jpg")
                )
            ),
            continuationToken = null
        )

        val viewModel = createViewModel()
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.setArtistSearchQuery("Dua")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Dua", viewModel.uiState.value.artistSearchQuery)
        assertEquals(1, viewModel.uiState.value.artistSearchResults.size)
        assertEquals("Dua Lipa", viewModel.uiState.value.artistSearchResults.first().name)
    }
}
