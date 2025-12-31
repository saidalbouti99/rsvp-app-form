package com.example.rsvpform.features.rsvp.models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit service interface defining the network endpoints for RSVP operations.
 */
interface RsvpApiService {

    /**
     * Submits an RSVP form to the server.
     *
     * NOTE: This endpoint uses HTTP GET to submit data via query parameters as required
     * by the MiCare backend implementation. Using POST will result in a 405 Method
     * Not Allowed error.
     *
     * @param apiKey The authentication key (Default: "123456").
     * @param firstName The attendee's first name.
     * @param lastName The attendee's last name.
     * @param contactNo The attendee's numeric contact phone number.
     * @param email The attendee's validated email address.
     * * @return A [Response] containing [Unit]. Success is indicated by a 200 OK status.
     */
    @GET("interviewapi/AssessmentTestRSVP")
    suspend fun submitRsvp(
        @Query("ApiKey") apiKey: String = "123456",
        @Query("FirstName") firstName: String,
        @Query("LastName") lastName: String,
        @Query("ContactNo") contactNo: String,
        @Query("Email") email: String
    ): Response<Unit>
}