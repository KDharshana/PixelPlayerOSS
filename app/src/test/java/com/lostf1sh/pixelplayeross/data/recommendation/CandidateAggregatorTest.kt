package com.lostf1sh.pixelplayeross.data.recommendation

import com.google.common.truth.Truth.assertThat
import com.lostf1sh.pixelplayeross.data.listenbrainz.ListenBrainzRepository
import com.lostf1sh.pixelplayeross.data.model.Song
import com.lostf1sh.pixelplayeross.data.repository.MusicRepository
import com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository
import io.mockk.mockk
import org.junit.jupiter.api.Test

class CandidateAggregatorTest {

    private fun testSong(id: String, title: String, artist: String): Song = Song(
        id = id,
        title = title,
        artist = artist,
        artistId = 10L,
        album = "Album",
        albumId = 10L,
        path = "path/$id",
        contentUriString = "content://music/$id",
        albumArtUriString = null,
        duration = 180000L,
        mimeType = "audio/mpeg",
        bitrate = 320000,
        sampleRate = 44100
    )

    @Test
    fun `deduplicateCandidates retains higher source strength candidate on duplicate`() {
        val song1 = testSong("1", "Track A", "Artist A")

        val candidateLow = RecommendationCandidate(
            song = song1,
            sourceType = CandidateSourceType.GENRE_EXPANSION,
            sourceStrength = 0.5
        )

        val candidateHigh = RecommendationCandidate(
            song = song1,
            sourceType = CandidateSourceType.YT_RADIO,
            sourceStrength = 0.9
        )

        val aggregator = CandidateAggregator(
            youTubeRepository = mockk<YouTubeRepository>(relaxed = true),
            listenBrainzRepository = mockk<ListenBrainzRepository>(relaxed = true),
            musicRepository = mockk<MusicRepository>(relaxed = true),
            itemEmbeddingStore = mockk<ItemEmbeddingStore>(relaxed = true),
            userPreferencesRepository = mockk(relaxed = true)
        )

        val deduplicated = aggregator.deduplicateCandidates(listOf(candidateLow, candidateHigh))
        assertThat(deduplicated).hasSize(1)
        assertThat(deduplicated.first().sourceType).isEqualTo(CandidateSourceType.YT_RADIO)
        assertThat(deduplicated.first().sourceStrength).isEqualTo(0.9)
    }
}
