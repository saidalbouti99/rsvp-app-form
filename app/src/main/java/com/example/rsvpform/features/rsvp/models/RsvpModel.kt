package com.example.rsvpform.features.rsvp.models

import com.google.gson.annotations.SerializedName

/**
 * Data representation of the RSVP submission.
 */
data class RsvpModel(
    @SerializedName("ApiKey")
    val apiKey: String = "123456",

    @SerializedName("FirstName")
    val firstName: String,

    @SerializedName("LastName")
    val lastName: String,

    @SerializedName("ContactNo")
    val contactNo: String,

    @SerializedName("Email")
    val email: String
)