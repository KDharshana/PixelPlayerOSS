package com.lostf1sh.pixelplayeross.data.recommendation

import com.google.common.truth.Truth.assertThat
import com.lostf1sh.pixelplayeross.data.database.ItemCooccurrenceDao
import com.lostf1sh.pixelplayeross.data.database.ItemCooccurrenceEntity
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ItemEmbeddingStoreTest {

    private val dao = mock(ItemCooccurrenceDao::class.java)
    private val store = ItemEmbeddingStore(dao)

    @Test
    fun `recordPairwisePlay normalizes key order before DAO increment`() = runTest {
        store.recordPairwisePlay("song_z", "song_a", 1000L)
        verify(dao).incrementCooccurrence("song_a", "song_z", 1000L)
    }

    @Test
    fun `getSimilarSongs computes normalized edge scores`() = runTest {
        val rows = listOf(
            ItemCooccurrenceEntity("song_1", "song_2", cooccurrenceCount = 10),
            ItemCooccurrenceEntity("song_1", "song_3", cooccurrenceCount = 5)
        )
        `when`(dao.getCooccurrencesForSong("song_1", 20)).thenReturn(rows)

        val similar = store.getSimilarSongs("song_1", 10)
        assertThat(similar).hasSize(2)
        assertThat(similar[0].first).isEqualTo("song_2")
        assertThat(similar[0].second).isEqualTo(1.0)
        assertThat(similar[1].first).isEqualTo("song_3")
        assertThat(similar[1].second).isEqualTo(0.5)
    }
}
