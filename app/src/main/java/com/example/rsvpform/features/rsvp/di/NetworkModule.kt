package com.example.rsvpform.features.rsvp.di


import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Global networking module for the application.
 * * Defines the foundational [OkHttpClient] and [Retrofit] instances used across the app.
 * Timeouts are set to 30 seconds to accommodate potential slow network conditions.
 */
val networkModule = module {

    /** Provides a singleton [OkHttpClient] configured with default timeouts. */
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    /** * Provides a singleton [Retrofit] instance.
     * * Uses the MiCare integration base URL and attaches the [OkHttpClient]
     * and [GsonConverterFactory] for JSON-to-Model conversion.
     */
    single {
        Retrofit.Builder()
            .baseUrl("https://integration.micaresvc.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}