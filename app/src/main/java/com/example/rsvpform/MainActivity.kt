package com.example.rsvpform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.rsvpform.features.rsvp.viewmodels.RsvpViewModel
import com.example.rsvpform.features.rsvp.views.RsvpScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: RsvpViewModel = koinViewModel()
                RsvpScreen(viewModel)
            }
        }
    }
}