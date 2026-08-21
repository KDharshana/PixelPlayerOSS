package com.lostf1sh.pixelplayeross.data.youtube

import com.lostf1sh.pixelplayeross.data.database.YouTubeDao
import com.lostf1sh.pixelplayeross.data.database.YouTubePlaylistEntity
import com.lostf1sh.pixelplayeross.data.database.YouTubeSongEntity
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeAlbum
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeArtist
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeApiService
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeBrowseSection
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubePlaylist
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeSearchResult
import com.lostf1sh.pixelplayeross.data.network.youtube.InnertubeTrack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository orchestrating YouTube Music search, charts, streaming resolution,
 * and local library caching.
 */
@Singleton
class YouTubeRepository @Inject constructor(
    private val innertubeApiService: InnertubeApiService,
    private val youTubeExtractorManager: com.lostf1sh.pixelplayeross.data.network.youtube.YouTubeExtractorManager,
    private val youTubeDao: YouTubeDao
) {
    private companion object {
        private const val TAG = "YouTubeRepository"
    }

    /**
     * Observes all locally cached / synced YouTube Music songs from the database.
     */
    val cachedSongsFlow: Flow<List<Song>> = youTubeDao.getAllYouTubeSongs().map { entities ->
        entities.map { it.toSong() }
    }.flowOn(Dispatchers.IO)

    /**
     * Observes all synced YouTube Music playlists from the database.
     */
    val playlistsFlow: Flow<List<YouTubePlaylistEntity>> = youTubeDao.getAllPlaylists()
        .flowOn(Dispatchers.IO)

    data class YouTubePageResult(
        val songs: List<Song>,
        val continuationToken: String?
    )

    data class YouTubeMultiPageResult(
        val items: List<com.lostf1sh.pixelplayeross.data.model.SearchResultItem>,
        val continuationToken: String?
    )

    data class HomeRecommendations(
        val fromCommunity: List<Song> = emptyList(),
        val trendingCommunityPlaylists: List<com.lostf1sh.pixelplayeross.data.model.Playlist> = emptyList(),
        val featuredPlaylists: List<com.lostf1sh.pixelplayeross.data.model.Playlist> = emptyList(),
        val mixedForYou: List<com.lostf1sh.pixelplayeross.data.model.Playlist> = emptyList()
    )

    /**
     * Searches YouTube Music for songs matching the query with continuation support.
     */
    suspend fun searchSongsPaginated(query: String, continuation: String? = null): YouTubePageResult = withContext(Dispatchers.IO) {
        if (query.isBlank() && continuation.isNullOrBlank()) {
            return@withContext YouTubePageResult(emptyList(), null)
        }
        val result = innertubeApiService.search(query, InnertubeApiService.YTM_FILTER_SONGS, continuation)
        val songs = result.songs.map { it.toDomainSong() }
        YouTubePageResult(songs, result.continuationToken)
    }

    /**
     * Searches YouTube Music across multi-category filters (Songs, Albums, Artists, Playlists).
     */
    suspend fun searchAllPaginated(
        query: String,
        filterType: com.lostf1sh.pixelplayeross.data.model.SearchFilterType = com.lostf1sh.pixelplayeross.data.model.SearchFilterType.ALL,
        continuation: String? = null
    ): YouTubeMultiPageResult = withContext(Dispatchers.IO) {
        if (query.isBlank() && continuation.isNullOrBlank()) {
            return@withContext YouTubeMultiPageResult(emptyList(), null)
        }
        val params = when (filterType) {
            com.lostf1sh.pixelplayeross.data.model.SearchFilterType.ALL -> null
            com.lostf1sh.pixelplayeross.data.model.SearchFilterType.SONGS -> InnertubeApiService.YTM_FILTER_SONGS
            com.lostf1sh.pixelplayeross.data.model.SearchFilterType.ALBUMS -> InnertubeApiService.YTM_FILTER_ALBUMS
            com.lostf1sh.pixelplayeross.data.model.SearchFilterType.ARTISTS -> InnertubeApiService.YTM_FILTER_ARTISTS
            com.lostf1sh.pixelplayeross.data.model.SearchFilterType.PLAYLISTS -> InnertubeApiService.YTM_FILTER_PLAYLISTS
        }
        val result = innertubeApiService.search(query, params, continuation)
        val items = mutableListOf<com.lostf1sh.pixelplayeross.data.model.SearchResultItem>()
        result.songs.forEach { items.add(com.lostf1sh.pixelplayeross.data.model.SearchResultItem.SongItem(it.toDomainSong())) }
        result.albums.forEach { items.add(com.lostf1sh.pixelplayeross.data.model.SearchResultItem.AlbumItem(it.toDomainAlbum())) }
        result.artists.forEach { items.add(com.lostf1sh.pixelplayeross.data.model.SearchResultItem.ArtistItem(it.toDomainArtist())) }
        result.playlists.forEach { items.add(com.lostf1sh.pixelplayeross.data.model.SearchResultItem.PlaylistItem(it.toDomainPlaylist())) }
        YouTubeMultiPageResult(items, result.continuationToken)
    }

    /**
     * Fetches categorized recommendations from YouTube Music browse feed.
     */
    suspend fun getHomeRecommendations(): HomeRecommendations = withContext(Dispatchers.IO) {
        try {
            val sections = innertubeApiService.getBrowse("FEmusic_home")
            val communitySongs = mutableListOf<Song>()
            val trendingPlaylists = mutableListOf<com.lostf1sh.pixelplayeross.data.model.Playlist>()
            val featuredPlaylists = mutableListOf<com.lostf1sh.pixelplayeross.data.model.Playlist>()
            val mixedPlaylists = mutableListOf<com.lostf1sh.pixelplayeross.data.model.Playlist>()

            for (section in sections) {
                val titleLower = section.title.lowercase()
                val subtitleLower = section.subtitle?.lowercase() ?: ""
                when {
                    titleLower.contains("mix") || titleLower.contains("for you") || subtitleLower.contains("mix") -> {
                        mixedPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                    }
                    titleLower.contains("trending") || titleLower.contains("community") || titleLower.contains("popular") -> {
                        trendingPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                        communitySongs.addAll(section.tracks.map { it.toDomainSong() })
                    }
                    titleLower.contains("featured") || titleLower.contains("today") || titleLower.contains("charts") || titleLower.contains("hits") -> {
                        featuredPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                        if (communitySongs.isEmpty()) {
                            communitySongs.addAll(section.tracks.map { it.toDomainSong() })
                        }
                    }
                    else -> {
                        if (mixedPlaylists.size < 6 && section.playlists.isNotEmpty()) {
                            mixedPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                        } else if (trendingPlaylists.size < 6 && section.playlists.isNotEmpty()) {
                            trendingPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                        } else {
                            featuredPlaylists.addAll(section.playlists.map { it.toDomainPlaylist() })
                        }
                        if (communitySongs.size < 20) {
                            communitySongs.addAll(section.tracks.map { it.toDomainSong() })
                        }
                    }
                }
            }

            HomeRecommendations(
                fromCommunity = communitySongs.distinctBy { it.id },
                trendingCommunityPlaylists = trendingPlaylists.distinctBy { it.id },
                featuredPlaylists = featuredPlaylists.distinctBy { it.id },
                mixedForYou = mixedPlaylists.distinctBy { it.id }
            )
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Failed to load home recommendations")
            HomeRecommendations()
        }
    }

    /**
     * Fetches details and songs for an online YouTube playlist.
     */
    suspend fun getPlaylist(playlistId: String): Pair<com.lostf1sh.pixelplayeross.data.model.Playlist, List<Song>>? = withContext(Dispatchers.IO) {
        try {
            val result = innertubeApiService.getPlaylist(playlistId) ?: return@withContext null
            val (innertubePlaylist, innertubeTracks) = result
            val songs = innertubeTracks.map { it.toDomainSong() }
            val playlist = innertubePlaylist.toDomainPlaylist().copy(
                songIds = songs.map { it.id }
            )
            songs.forEach { song ->
                try {
                    saveTrackToLibrary(song)
                } catch (_: Exception) {}
            }
            Pair(playlist, songs)
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Error loading playlist: $playlistId")
            null
        }
    }

    /**
     * Searches YouTube Music for songs matching the query.
     */
    fun searchSongs(query: String): Flow<List<Song>> = flow {
        if (query.isBlank()) {
            emit(emptyList())
            return@flow
        }
        val result = innertubeApiService.search(query)
        val songs = result.songs.map { it.toDomainSong() }
        emit(songs)
    }.flowOn(Dispatchers.IO)

    /**
     * Fetches top charts / trending music tracks.
     */
    fun getCharts(): Flow<List<Song>> = flow {
        val sections = innertubeApiService.getBrowse("FEmusic_charts")
        val tracks = sections.flatMap { it.tracks }.map { it.toDomainSong() }
        emit(tracks)
    }.flowOn(Dispatchers.IO)

    /**
     * Fetches browse sections for the Explore/Discover screen.
     */
    fun getExploreSections(): Flow<List<InnertubeBrowseSection>> = flow {
        val sections = innertubeApiService.getBrowse("FEmusic_home")
        emit(sections)
    }.flowOn(Dispatchers.IO)

    /**
     * Resolves the direct audio stream URL for a given YouTube video ID.
     */
    suspend fun getStreamUrl(videoId: String): String? = withContext(Dispatchers.IO) {
        val extractedUrl = runCatching { youTubeExtractorManager.extractAudioStreamUrl(videoId) }.getOrNull()
        if (!extractedUrl.isNullOrBlank()) {
            return@withContext extractedUrl
        }
        val streamInfo = runCatching { innertubeApiService.getStreamInfo(videoId) }.getOrNull()
        streamInfo?.selectedFormatUrl ?: streamInfo?.highestBitrateOpusUrl ?: streamInfo?.highestBitrateAacUrl
    }

    /**
     * Fetches timestamped lyrics for a track if available.
     */
    suspend fun getLyrics(videoId: String): String? = withContext(Dispatchers.IO) {
        innertubeApiService.getTranscriptLyrics(videoId)
    }

    /**
     * Fetches radio / autoplay recommended tracks for a given YouTube video ID.
     */
    suspend fun getRadioTracks(videoId: String): List<Song> = withContext(Dispatchers.IO) {
        val tracks = innertubeApiService.getRadioTracks(videoId)
        tracks.map { it.toDomainSong() }
    }

    /**
     * Fetches radio / autoplay tracks for any song (local or online).
     */
    suspend fun getRadioTracksForSong(song: Song): List<Song> = withContext(Dispatchers.IO) {
        val videoId = song.youtubeId
            ?: song.contentUriString.takeIf { it.startsWith("youtube://") }?.removePrefix("youtube://")
            ?: run {
                val searchResult = innertubeApiService.search("${song.title} ${song.artist}")
                searchResult.songs.firstOrNull()?.videoId
            }

        if (videoId.isNullOrBlank()) return@withContext emptyList()
        getRadioTracks(videoId)
    }

    /**
     * Saves a YouTube Music track to the local database library.
     */
    suspend fun saveTrackToLibrary(song: Song) = withContext(Dispatchers.IO) {
        val videoId = song.youtubeId ?: song.contentUriString.removePrefix("youtube://")
        val entity = YouTubeSongEntity(
            id = song.id,
            videoId = videoId,
            playlistId = "__library__",
            title = song.title,
            artist = song.artist,
            album = song.album,
            duration = song.duration,
            thumbnailUrl = song.albumArtUriString,
            year = song.year,
            dateAdded = System.currentTimeMillis()
        )
        youTubeDao.insertSong(entity)
    }

    /**
     * Removes a track from the local cached YouTube library.
     */
    suspend fun removeTrackFromLibrary(songId: String) = withContext(Dispatchers.IO) {
        youTubeDao.deleteSong(songId)
    }

    private fun InnertubeTrack.toDomainSong(): Song {
        return Song(
            id = "youtube_$videoId",
            title = title,
            artist = artist,
            artistId = 0L,
            album = album ?: "YouTube Music",
            albumId = 0L,
            albumArtist = artist,
            path = "youtube://$videoId",
            contentUriString = "youtube://$videoId",
            albumArtUriString = thumbnailUri,
            duration = durationSeconds * 1000L,
            mimeType = "audio/webm",
            bitrate = 160000,
            sampleRate = 48000,
            youtubeId = videoId
        )
    }

    private fun InnertubeAlbum.toDomainAlbum(): com.lostf1sh.pixelplayeross.data.model.Album {
        val calculatedId = -Math.abs(browseId.hashCode().toLong())
        return com.lostf1sh.pixelplayeross.data.model.Album(
            id = calculatedId,
            title = title,
            artist = artist,
            year = year ?: 0,
            dateAdded = System.currentTimeMillis(),
            albumArtUriString = thumbnailUri,
            songCount = trackCount,
            albumArtist = artist
        )
    }

    private fun InnertubeArtist.toDomainArtist(): com.lostf1sh.pixelplayeross.data.model.Artist {
        val calculatedId = -Math.abs(browseId.hashCode().toLong())
        return com.lostf1sh.pixelplayeross.data.model.Artist(
            id = calculatedId,
            name = name,
            songCount = 0,
            imageUrl = thumbnailUri,
            customImageUri = null
        )
    }

    private fun InnertubePlaylist.toDomainPlaylist(): com.lostf1sh.pixelplayeross.data.model.Playlist {
        return com.lostf1sh.pixelplayeross.data.model.Playlist(
            id = playlistId,
            name = title,
            songIds = emptyList(),
            coverImageUri = thumbnailUri,
            source = "YOUTUBE"
        )
    }
}
