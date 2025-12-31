package com.example.rsvpform

import com.example.rsvpform.features.rsvp.models.RsvpApiService
import com.example.rsvpform.features.rsvp.models.RsvpModel
import com.example.rsvpform.features.rsvp.repositories.RsvpRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

/**
 * Unit tests for [RsvpRepository].
 * * Verifies that the repository correctly delegates calls to the [RsvpApiService].
 */
class RsvpRepositoryTest {

    // Mocking the API Service dependency
    private val apiService: RsvpApiService = mockk()

    // The Class Under Test
    private lateinit var repository: RsvpRepository

    @Before
    fun setUp() {
        repository = RsvpRepository(apiService)
    }

    /**
     * Test case to verify that repository returns a successful response.
     */
    @Test
    fun `submitRsvp returns successful response when API call succeeds`() = runTest {
        // Given: A valid model and a mocked success response
        val model =
            RsvpModel(firstName = "James", lastName = "Wong", contactNo = "0123", email = "j@g.com")
        coEvery {
            apiService.submitRsvp(any(), any(), any(), any(), any())
        } returns Response.success(Unit)

        // When: We call the repository
        val result = repository.submitRsvp(model)

        // Then: The response should be successful and the service called once
        assertTrue(result.isSuccessful)
        coVerify(exactly = 1) { apiService.submitRsvp(any(), any(), any(), any(), any()) }
    }

    /**
     * Test case to verify repository behavior when the server returns an error.
     */
    @Test
    fun `submitRsvp returns error response when API call fails`() = runTest {
        // Given: A mocked failure (e.g., 400 Bad Request)
        val model = RsvpModel(firstName = "James", lastName = "Wong", contactNo = "0123", email = "j@g.com")
        coEvery {
            apiService.submitRsvp(any(), any(), any(), any(), any())
        } returns Response.error(400, "Bad Request".toResponseBody())

        // When: We call the repository
        val result = repository.submitRsvp(model)

        // Then: The result should not be successful
        assertFalse(result.isSuccessful)
    }
}