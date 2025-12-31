package com.example.rsvpform.features.rsvp.viewmodels

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rsvpform.features.rsvp.models.RsvpModel
import com.example.rsvpform.features.rsvp.repositories.RsvpRepository
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for managing the state and business logic of the RSVP form.
 *
 * @property repository The data repository used to coordinate RSVP submissions.
 */
class RsvpViewModel(private val repository: RsvpRepository): ViewModel() {

    // --- Form State ---

    /** The user's first name. Limited to 100 characters in validation. */
    var firstName by mutableStateOf("")

    /** The user's last name. Limited to 100 characters in validation. */
    var lastName by mutableStateOf("")

    /** The contact phone number. Must be numeric only. */
    var contactNo by mutableStateOf("")

    /** The email address. Validated against [Patterns.EMAIL_ADDRESS] and limited to 300 characters. */
    var email by mutableStateOf("")

    // --- UI Feedback State ---

    /** Indicates if a network request is currently in progress to prevent duplicate submissions. */
    var isSubmitting by mutableStateOf(false)

    /** Holds the current validation or network error message, or null if no error exists. */
    var errorMessage by mutableStateOf<String?>(null)

    /** Controls the visibility of the "THANK YOU" success dialog. */
    var showSuccessDialog by mutableStateOf(false)

    /**
     * Orchestrates the submission process by communicating with the [repository].
     */
    fun onSubmit() {
        if (!isInputValid()) return

        viewModelScope.launch {
            isSubmitting = true
            errorMessage = null
            try {
                val request = RsvpModel(
                    apiKey = "123456",
                    firstName = firstName,
                    lastName = lastName,
                    contactNo = contactNo,
                    email = email
                )

                val response = repository.submitRsvp(request)

                if (response.isSuccessful) {
                    showSuccessDialog = true
                } else {
                    errorMessage = "Submission failed. Please try again."
                }
            } catch (e: Exception) {
                errorMessage = "Network error: ${e.localizedMessage}"
            } finally {
                isSubmitting = false
            }
        }
    }

    /**
     * Validates form inputs against business requirements.
     * * Requirements:
     * - All fields must be non-blank.
     * - First and Last names <= 100 characters.
     * - Email must be a valid format and <= 300 characters.
     * - Contact number must contain digits only.
     * * @return true if all inputs meet the requirements, false otherwise.
     */
    private fun isInputValid(): Boolean {
        return when {
            firstName.isBlank() || lastName.isBlank() || contactNo.isBlank() || email.isBlank() -> {
                errorMessage = "Please enter all the fields"
                false
            }
            firstName.length > 100 || lastName.length > 100 -> {
                errorMessage = "Names must be under 100 characters"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.length > 300 -> {
                errorMessage = "Please enter a valid email"
                false
            }
            !contactNo.all { it.isDigit() } -> {
                errorMessage = "Contact number must contain only numbers"
                false
            }
            else -> true
        }
    }

    /**
     * Resets the form state and error messages to their initial values.
     * Typically called after a successful submission when the user dismisses the success dialog.
     */
    fun clearForm() {
        firstName = ""
        lastName = ""
        contactNo = ""
        email = ""
        errorMessage = null
    }
}