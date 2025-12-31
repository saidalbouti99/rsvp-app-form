package com.example.rsvpform.features.rsvp

import android.app.Application
import com.example.rsvpform.features.rsvp.di.networkModule
import com.example.rsvpform.features.rsvp.di.rsvpFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Main application class responsible for initializing the dependency injection framework.
 * * Uses Koin to manage the lifecycle of network and feature modules.
 */
class RsvpApplication : Application() {

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * * Sets up the Koin DI container with the defined [networkModule] and [rsvpFeatureModule].
     */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RsvpApplication)
            modules(listOf(networkModule, rsvpFeatureModule))
        }
    }
}