package com.example.rsvpform.features.rsvp.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rsvpform.ui.theme.TealPrimary

/**
 * Displays a validation or network error message within the RSVP form.
 *
 * Uses the [TealPrimary] color to maintain consistent visual feedback
 * for warnings and errors.
 *
 * @param message The error string to be displayed to the user.
 */
@Composable
fun RsvpErrorText(message: String) {
    Text(
        text = message,
        color = TealPrimary,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        textAlign = TextAlign.Start
    )
}