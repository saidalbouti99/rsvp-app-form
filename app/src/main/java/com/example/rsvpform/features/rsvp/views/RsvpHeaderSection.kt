package com.example.rsvpform.features.rsvp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rsvpform.ui.theme.RedHeader

/**
 * The branding header for the RSVP screen.
 * * Features a high-contrast [RedHeader] background with a distinctive vertical
 * white line as a visual separator between the title and the response instructions.
 * This component is designed to be partially overlapped by the form container below it.
 */
@Composable
fun RsvpHeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(RedHeader)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "RSVP Form",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .width(2.dp)
                .height(40.dp)
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Kindly respond by February 06, 2026",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "We look forward to celebrate with you",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}
