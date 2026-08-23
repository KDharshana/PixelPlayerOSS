package com.lostf1sh.pixelplayeross.presentation.viewmodel

import com.lostf1sh.pixelplayeross.data.model.SearchFilterType
import com.lostf1sh.pixelplayeross.data.model.SearchHistoryItem
import com.lostf1sh.pixelplayeross.data.model.SearchResultItem
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.FlowPreview

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

/**
 * Manages search state and operations.
 * Extracted from PlayerViewModel to improve modularity.
 *
 * Responsibilities:
 * - Search query execution
 * - Search filter management
 * - Search history CRUD operations
 */
@Singleton
class SearchStateHolder @Inject constructor(
    private val musicRepository: MusicRepository,
    private val youTubeRepository: com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository,
    private val engagementDao: com.lostf1sh.pixelplayeross.data.database.EngagementDao
) {
    private companion object {
        const val SEARCH_DEBOUNCE_MS = 150L
    }

    private data class SearchRequest(
        val query: String,
        val requestId: Long,
    )

    private val _searchResults = MutableStateFlow<ImmutableList<SearchResultItem>>(persistentListOf())
    val searchResults = _searchResults.asStateFlow()

    private val _selectedSearchFilter = MutableStateFlow(SearchFilterType.ALL)
    val selectedSearchFilter = _selectedSearchFilter.asStateFlow()

    private val _isSearchingOnline = MutableStateFlow(false)
    val isSearchingOnline = _isSearchingOnline.asStateFlow()

    private val _isLoadingMore = MutableStateFlow(false)
    val isLoadingMore = _isLoadingMore.asStateFlow()

    private val _searchHistory = MutableStateFlow<ImmutableList<SearchHistoryItem>>(persistentListOf())
    val searchHistory = _searchHistory.asStateFlow()

    private val searchRequests = MutableSharedFlow<SearchRequest>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    private val latestSearchRequestId = AtomicLong(0L)
    private var currentContinuationToken: String? = null
    private var lastQuery: String = ""

    private var scope: CoroutineScope? = null
    private var searchJob: Job? = null

    /**
     * Initialize with ViewModel scope.
     */
    fun initialize(scope: CoroutineScope) {
        this.scope = scope
        observeSearchRequests()
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchRequests() {
        searchJob?.cancel()
        searchJob = scope?.launch {
            searchRequests
                .debounce(SEARCH_DEBOUNCE_MS)
                .collectLatest { request ->
                    val normalizedQuery = request.query
                    lastQuery = normalizedQuery
                    currentContinuationToken = null

                    if (normalizedQuery.isBlank()) {
                        _searchResults.value = persistentListOf()
                        _isSearchingOnline.value = false
                        return@collectLatest
                    }

                    val currentFilter = _selectedSearchFilter.value
                    var currentLocalResults: List<SearchResultItem> = emptyList()
                    var currentOnlineResults: List<SearchResultItem> = emptyList()

                    fun updateCombinedResults() {
                        if (request.requestId != latestSearchRequestId.get()) return
                        val engagementsMap = runCatching {
                            engagementDao.getAllEngagements().associateBy { it.songId }
                        }.getOrDefault(emptyMap())

                        val combined = (currentLocalResults + currentOnlineResults).distinctBy { it.dedupKey() }
                        val sortedCombined = sortSearchResultsByPopularity(combined, normalizedQuery, engagementsMap)
                        _searchResults.value = sortedCombined.toImmutableList()
                    }

                    // 1. Stage 1: Immediate Local Search (FTS4 SQLite with popularity ranking)
                    val localJob = launch {
                        try {
                            musicRepository.searchAll(normalizedQuery, currentFilter).collect { localList ->
                                if (request.requestId != latestSearchRequestId.get()) return@collect
                                currentLocalResults = localList
                                updateCombinedResults()
                            }
                        } catch (_: CancellationException) {
                        } catch (e: Exception) {
                            Timber.tag("SearchStateHolder").e(e, "Local search error for: $normalizedQuery")
                        }
                    }

                    // 2. Stage 2: Background Progressive Online Search (YouTube Music ranked high to low popularity)
                    launch {
                        _isSearchingOnline.value = true
                        try {
                            val ytResult = youTubeRepository.searchAllPaginated(normalizedQuery, currentFilter)
                            if (request.requestId != latestSearchRequestId.get()) return@launch

                            currentContinuationToken = ytResult.continuationToken
                            currentOnlineResults = ytResult.items
                            updateCombinedResults()
                        } catch (_: CancellationException) {
                        } catch (e: Exception) {
                            Timber.tag("SearchStateHolder").e(e, "Online search error for: $normalizedQuery")
                        } finally {
                            if (request.requestId == latestSearchRequestId.get()) {
                                _isSearchingOnline.value = false
                            }
                        }
                    }
                }
        }
    }

    private fun SearchResultItem.dedupKey(): String = when (this) {
        is SearchResultItem.SongItem -> "song_${song.id}_${song.title.lowercase().trim()}_${song.artist.lowercase().trim()}"
        is SearchResultItem.AlbumItem -> "album_${album.id}"
        is SearchResultItem.ArtistItem -> "artist_${artist.id}"
        is SearchResultItem.PlaylistItem -> "playlist_${playlist.id}"
    }

    /**
     * Ranks search result items strictly from high to low popularity and query relevance.
     */
    private fun sortSearchResultsByPopularity(
        items: List<SearchResultItem>,
        query: String,
        engagementsMap: Map<String, com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity>
    ): List<SearchResultItem> {
        if (items.isEmpty() || query.isBlank()) return items

        val lowerQuery = query.lowercase().trim()

        return items.mapIndexed { originalIndex, item ->
            val relevanceScore = computeRelevanceScore(item, lowerQuery)
            val popularityScore = computePopularityScore(item, engagementsMap, originalIndex)
            val totalScore = (relevanceScore * 2.0) + popularityScore
            item to totalScore
        }.sortedByDescending { it.second }
        .map { it.first }
    }

    private fun computeRelevanceScore(item: SearchResultItem, lowerQuery: String): Double {
        val (primaryText, secondaryText) = when (item) {
            is SearchResultItem.SongItem -> item.song.title.lowercase().trim() to item.song.artist.lowercase().trim()
            is SearchResultItem.AlbumItem -> item.album.title.lowercase().trim() to item.album.artist.lowercase().trim()
            is SearchResultItem.ArtistItem -> item.artist.name.lowercase().trim() to ""
            is SearchResultItem.PlaylistItem -> item.playlist.name.lowercase().trim() to ""
        }

        return when {
            primaryText == lowerQuery -> 100.0
            secondaryText == lowerQuery -> 90.0
            primaryText.startsWith(lowerQuery) -> 75.0
            secondaryText.startsWith(lowerQuery) -> 65.0
            primaryText.contains("\\b${Regex.escape(lowerQuery)}\\b".toRegex()) -> 55.0
            primaryText.contains(lowerQuery) -> 40.0
            secondaryText.contains(lowerQuery) -> 30.0
            else -> 10.0
        }
    }

    private fun computePopularityScore(
        item: SearchResultItem,
        engagementsMap: Map<String, com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity>,
        originalIndex: Int
    ): Double {
        return when (item) {
            is SearchResultItem.SongItem -> {
                val song = item.song
                val engagement = engagementsMap[song.id]
                val playScore = (engagement?.playCount ?: 0) * 3.0
                val completionScore = (engagement?.completionCount ?: 0) * 4.0
                val repeatScore = (engagement?.sessionRepeatCount ?: 0) * 3.5
                val skipPenalty = (engagement?.skipBefore30sCount ?: 0) * 1.5
                val favBonus = if (song.isFavorite) 20.0 else 0.0

                // YouTube items preserve online search index popularity (top hits rank highest)
                val onlinePopularity = if (song.youtubeId != null || song.id.startsWith("youtube_")) {
                    maxOf(0.0, 50.0 - (originalIndex * 1.5))
                } else {
                    0.0
                }

                playScore + completionScore + repeatScore + favBonus + onlinePopularity - skipPenalty
            }
            is SearchResultItem.ArtistItem -> {
                maxOf(0.0, 45.0 - (originalIndex * 1.5))
            }
            is SearchResultItem.AlbumItem -> {
                maxOf(0.0, 35.0 - (originalIndex * 1.5))
            }
            is SearchResultItem.PlaylistItem -> {
                maxOf(0.0, 25.0 - (originalIndex * 1.5))
            }
        }
    }

    fun loadMoreSearchResults() {
        val continuation = currentContinuationToken ?: return
        if (_isLoadingMore.value || lastQuery.isBlank()) return

        scope?.launch {
            _isLoadingMore.value = true
            try {
                val pageResult = youTubeRepository.searchAllPaginated(
                    query = lastQuery,
                    filterType = _selectedSearchFilter.value,
                    continuation = continuation
                )
                currentContinuationToken = pageResult.continuationToken
                if (pageResult.items.isNotEmpty()) {
                    val existingKeys = _searchResults.value.map { it.dedupKey() }.toSet()
                    val newUniqueItems = pageResult.items.filter { it.dedupKey() !in existingKeys }

                    if (newUniqueItems.isNotEmpty()) {
                        val engagementsMap = runCatching {
                            engagementDao.getAllEngagements().associateBy { it.songId }
                        }.getOrDefault(emptyMap())
                        val combined = (_searchResults.value + newUniqueItems).distinctBy { it.dedupKey() }
                        _searchResults.value = sortSearchResultsByPopularity(combined, lastQuery, engagementsMap).toImmutableList()
                    }
                }
            } catch (e: Exception) {
                Timber.e(e, "Error loading more search results")
            } finally {
                _isLoadingMore.value = false
            }
        }
    }

    fun updateSearchFilter(filterType: SearchFilterType) {
        if (_selectedSearchFilter.value == filterType) return
        _selectedSearchFilter.value = filterType
        currentContinuationToken = null
        if (lastQuery.isNotBlank()) {
            performSearch(lastQuery)
        }
    }

    fun loadSearchHistory(limit: Int = 15) {
        scope?.launch {
            try {
                val history = withContext(Dispatchers.IO) {
                    musicRepository.getRecentSearchHistory(limit)
                }
                _searchHistory.value = history.toImmutableList()
            } catch (e: Exception) {
                Timber.e(e, "Error loading search history")
            }
        }
    }

    fun onSearchQuerySubmitted(query: String) {
        scope?.launch {
            if (query.isNotBlank()) {
                try {
                    withContext(Dispatchers.IO) {
                        musicRepository.addSearchHistoryItem(query)
                    }
                    loadSearchHistory()
                } catch (e: Exception) {
                    Timber.e(e, "Error adding search history item")
                }
            }
        }
    }

    fun performSearch(query: String) {
        val normalizedQuery = query.trim()

        val requestId = latestSearchRequestId.incrementAndGet()

        if (normalizedQuery.isBlank()) {
            if (_searchResults.value.isNotEmpty()) {
                _searchResults.value = persistentListOf()
            }
        }

        searchRequests.tryEmit(SearchRequest(normalizedQuery, requestId))
    }

    fun deleteSearchHistoryItem(query: String) {
        scope?.launch {
            try {
                withContext(Dispatchers.IO) {
                    musicRepository.deleteSearchHistoryItemByQuery(query)
                }
                loadSearchHistory()
            } catch (e: Exception) {
                Timber.e(e, "Error deleting search history item")
            }
        }
    }

    fun clearSearchHistory() {
        scope?.launch {
            try {
                withContext(Dispatchers.IO) {
                    musicRepository.clearSearchHistory()
                }
                _searchHistory.value = persistentListOf()
            } catch (e: Exception) {
                Timber.e(e, "Error clearing search history")
            }
        }
    }

    fun onCleared() {
        searchJob?.cancel()
        scope = null
    }
}
