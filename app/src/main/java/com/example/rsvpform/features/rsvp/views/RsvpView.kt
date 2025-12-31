package com.example.rsvpform.features.rsvp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.example.rsvpform.features.rsvp.viewmodels.RsvpViewModel
import com.example.rsvpform.ui.theme.LightGrayBackground

/**
 * The main screen orchestrator for the RSVP feature.
 * * It manages the [Box] stack containing the [RsvpHeaderSection] and [RsvpFormSection].
 * It also handles the lifecycle of the [SuccessDialog] and ensures that focus is
 * programmatically returned to the start of the form upon successful submission reset.
 *
 * @param viewModel The [RsvpViewModel] instance provided via Dependency Injection.
 */
@Composable
fun RsvpScreen(viewModel: RsvpViewModel) {
    val scrollState = rememberScrollState()

    val firstNameFocusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGrayBackground)
    ) {
        // Form Header
        RsvpHeaderSection()

        // Form
        RsvpFormSection(
            viewModel = viewModel,
            firstNameFocusRequester = firstNameFocusRequester,
            scrollState = scrollState
        )
    }

    if (viewModel.showSuccessDialog) {
        SuccessDialog(onDismiss = {
            viewModel.showSuccessDialog = false

            // Clear the form data
            viewModel.clearForm()

            firstNameFocusRequester.requestFocus()
        })
    }
}