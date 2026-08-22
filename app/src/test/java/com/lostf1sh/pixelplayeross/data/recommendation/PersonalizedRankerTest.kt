package com.lostf1sh.pixelplayeross.data.recommendation

import com.google.common.truth.Truth.assertThat
import com.lostf1sh.pixelplayeross.data.database.SongEngagementEntity
import com.lostf1sh.pixelplayeross.data.model.Song
import org.junit.jupiter.api.Test
import java.util.Random

class PersonalizedRankerTest {

    private val ranker = PersonalizedRanker()

    @Test
    fun `rank gives higher score to completed tracks vs frequently skipped tracks`() {
        val songCompleted = Song(
            id = "song_completed",
            title = "Completed Track",
            artist = "Artist A",
            artistId = 1L,
            path = "path/1",
            duration = 180000L
        )

        val songSkipped = Song(
            id = "song_skipped",
            title = "Skipped Track",
            artist = "Artist B",
            artistId = 2L,
            path = "path/2",
            duration = 180000L
        )

        val candidateCompleted = RecommendationCandidate(
            song = songCompleted,
            sourceType = CandidateSourceType.YT_RADIO,
            sourceStrength = 0.8
        )

        val candidateSkipped = RecommendationCandidate(
            song = songSkipped,
            sourceType = CandidateSourceType.YT_RADIO,
            sourceStrength = 0.8
        )

        val engagements = mapOf(
            "song_completed" to SongEngagementEntity(
                songId = "song_completed",
                playCount = 10,
                totalPlayDurationMs = 1800000L,
                completionCount = 9,
                skipBefore30sCount = 0
            ),
            "song_skipped" to SongEngagementEntity(
                songId = "song_skipped",
                playCount = 10,
                totalPlayDurationMs = 1800000L,
                completionCount = 0,
                skipBefore30sCount = 8
            )
        )

        val ranked = ranker.rank(
            candidates = listOf(candidateCompleted, candidateSkipped),
            engagements = engagements,
            favoriteSongIds = emptySet(),
            random = Random(42)
        )

        assertThat(ranked).hasSize(2)
        assertThat(ranked[0].song.id).isEqualTo("song_completed")
        assertThat(ranked[0].finalScore).isGreaterThan(ranked[1].finalScore)
    }

    @Test
    fun `pickWithDiversity respects max artist limits`() {
        val songs = (1..6).map { i ->
            Song(
                id = "song_$i",
                title = "Title $i",
                artist = "Same Artist",
                artistId = 99L,
                path = "path/$i",
                duration = 180000L
            )
        }

        val candidates = songs.map { song ->
            PersonalizedRanker.ScoredCandidate(
                candidate = RecommendationCandidate(song, CandidateSourceType.YT_RADIO),
                finalScore = 1.0,
                affinityScore = 1.0,
                recencyScore = 1.0,
                noveltyScore = 1.0,
                favoriteScore = 0.0,
                sourceStrengthScore = 1.0
            )
        }

        val diversePicks = ranker.pickWithDiversity(candidates, emptySet(), limit = 2)
        assertThat(diversePicks).hasSize(2)
    }
}
