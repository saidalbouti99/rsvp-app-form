package com.example.rsvpform.features.rsvp.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rsvpform.ui.theme.TealPrimary

/**
 * The primary action button for form submission.
 * * Styled as a teal capsule (pill shape).
 * It handles its own loading state by swapping the "Submit" text with
 * a [CircularProgressIndicator] when [isSubmitting] is true.
 *
 * @param isSubmitting When true, disables clicks and shows a loading spinner.
 * @param onClick Callback executed when the button is pressed.
 */
@Composable
fun RsvpSubmitButton(
    isSubmitting: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = TealPrimary),
        enabled = !isSubmitting
    ) {
        if (isSubmitting) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.size(24.dp),
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = "Submit",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}