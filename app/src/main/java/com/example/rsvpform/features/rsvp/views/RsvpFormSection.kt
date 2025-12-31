package com.example.rsvpform.features.rsvp.views

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.rsvpform.features.rsvp.viewmodels.RsvpViewModel

/**
 * The primary form container for the RSVP screen.
 * * This component manages the layout of the input fields and the submission button
 * within a white [Surface] that overlaps the header. It handles:
 * 1. Vertical scrolling for small-screen compatibility.
 * 2. Focus management for the initial input field.
 * 3. Dynamic error message visibility.
 *
 * @param viewModel The state holder for form inputs and submission status.
 * @param firstNameFocusRequester The requester used to programmatically return focus
 * to the "First Name" field after form resets.
 * @param scrollState The state used to control the vertical scroll position of the form.
 */
@Composable
fun RsvpFormSection(
    viewModel: RsvpViewModel,
    firstNameFocusRequester: FocusRequester,
    scrollState: ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(220.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                viewModel.errorMessage?.let {
                    RsvpErrorText(message = it)
                }

                RsvpTextField(
                    label = "First Name",
                    value = viewModel.firstName,
                    onValueChange = { viewModel.firstName = it },
                    modifier = Modifier.focusRequester(firstNameFocusRequester)
                )
                RsvpTextField(
                    label = "Last Name",
                    value = viewModel.lastName,
                    onValueChange = { viewModel.lastName = it }
                )
                RsvpTextField(
                    label = "Contact Number",
                    value = viewModel.contactNo,
                    onValueChange = { viewModel.contactNo = it },
                    keyboardType = KeyboardType.Number
                )
                RsvpTextField(
                    label = "Email",
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(32.dp))

                RsvpSubmitButton(
                    isSubmitting = viewModel.isSubmitting,
                    onClick = { viewModel.onSubmit() }
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}