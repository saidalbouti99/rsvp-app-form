package com.example.rsvpform.features.rsvp.repositories

import com.example.rsvpform.features.rsvp.models.RsvpModel
import com.example.rsvpform.features.rsvp.models.RsvpApiService
import retrofit2.Response

/**
 * Repository that abstracts the data source for RSVP operations.
 * * This layer acts as a mediator between the [com.example.rsvpform.features.rsvp.viewmodels.RsvpViewModel] and [RsvpApiService].
 * It handles the execution of network requests and can be expanded to include
 * local caching logic in the future.
 */
class RsvpRepository(private val apiService: RsvpApiService) {

    /**
     * Executes the RSVP submission via the remote API.
     * * @param model The RSVP data to be submitted.
     * @return The network [Response] from the server.
     */
    suspend fun submitRsvp(model: RsvpModel): Response<Unit> {
        return apiService.submitRsvp(
            apiKey = model.apiKey,
            firstName = model.firstName,
            lastName = model.lastName,
            contactNo = model.contactNo,
            email = model.email
        )
    }
}