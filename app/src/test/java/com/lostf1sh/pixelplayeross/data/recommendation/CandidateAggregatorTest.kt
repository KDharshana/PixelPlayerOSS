package com.lostf1sh.pixelplayeross.data.recommendation

import com.google.common.truth.Truth.assertThat
import com.lostf1sh.pixelplayeross.data.model.Song
import org.junit.jupiter.api.Test

class CandidateAggregatorTest {

    @Test
    fun `deduplicateCandidates retains higher source strength candidate on duplicate`() {
        val song1 = Song(
            id = "1",
            title = "Track A",
            artist = "Artist A",
            artistId = 10L,
            path = "path/1",
            duration = 180000L
        )

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
            youTubeRepository = org.mockito.Mockito.mock(com.lostf1sh.pixelplayeross.data.youtube.YouTubeRepository::class.java),
            listenBrainzRepository = org.mockito.Mockito.mock(com.lostf1sh.pixelplayeross.data.listenbrainz.ListenBrainzRepository::class.java),
            musicRepository = org.mockito.Mockito.mock(com.lostf1sh.pixelplayeross.data.repository.MusicRepository::class.java)
        )

        val deduplicated = aggregator.deduplicateCandidates(listOf(candidateLow, candidateHigh))
        assertThat(deduplicated).hasSize(1)
        assertThat(deduplicated.first().sourceType).isEqualTo(CandidateSourceType.YT_RADIO)
        assertThat(deduplicated.first().sourceStrength).isEqualTo(0.9)
    }
}
