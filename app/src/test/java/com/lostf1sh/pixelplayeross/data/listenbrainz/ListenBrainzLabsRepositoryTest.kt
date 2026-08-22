package com.lostf1sh.pixelplayeross.data.listenbrainz

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListenBrainzLabsRepositoryTest {

    private lateinit var mockServer: MockWebServer
    private lateinit var labsApiService: ListenBrainzLabsApiService

    @BeforeEach
    fun setup() {
        mockServer = MockWebServer()
        labsApiService = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListenBrainzLabsApiService::class.java)
    }

    @AfterEach
    fun teardown() {
        mockServer.shutdown()
    }

    @Test
    fun `getSimilarArtists parses response correctly`() = runTest {
        val sampleJson = """
            [
                {
                    "artist_mbid": "65f4f0c5-ef9e-490c-aee3-909e7f6b2e4f",
                    "artist_name": "Metallica",
                    "similar_artists": [
                        {
                            "similar_artist_mbid": "a9044915-8c03-4c0e-920f-79647807e32f",
                            "similar_artist_name": "Megadeth",
                            "score": 0.892
                        },
                        {
                            "similar_artist_mbid": "2f40da1d-3bf3-4bbd-9f4a-9c7689dd9e8e",
                            "similar_artist_name": "Slayer",
                            "score": 0.765
                        }
                    ]
                }
            ]
        """.trimIndent()

        mockServer.enqueue(MockResponse().setResponseCode(200).setBody(sampleJson))

        val response = labsApiService.getSimilarArtists("65f4f0c5-ef9e-490c-aee3-909e7f6b2e4f")
        assertThat(response.isSuccessful).isTrue()
        val body = response.body()
        assertThat(body).isNotNull()
        assertThat(body?.size).isEqualTo(1)

        val first = body!!.first()
        assertThat(first.artistName).isEqualTo("Metallica")
        assertThat(first.similarArtists).hasSize(2)
        assertThat(first.similarArtists[0].name).isEqualTo("Megadeth")
        assertThat(first.similarArtists[0].score).isEqualTo(0.892)
        assertThat(first.similarArtists[1].name).isEqualTo("Slayer")
        assertThat(first.similarArtists[1].score).isEqualTo(0.765)
    }
}
