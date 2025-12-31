package com.example.rsvpform.features.rsvp.di

import com.example.rsvpform.features.rsvp.models.RsvpApiService
import com.example.rsvpform.features.rsvp.repositories.RsvpRepository
import com.example.rsvpform.features.rsvp.viewmodels.RsvpViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Feature-specific module for RSVP functionality.
 *
 * This module manages the lifecycle of:
 * 1. The [RsvpApiService] for network communication.
 * 2. The [RsvpRepository] for data abstraction and mediation.
 * 3. The [RsvpViewModel] for UI state management.
 */
val rsvpFeatureModule = module {
    /** * Provides the [RsvpApiService] implementation.
     * Created using the global [Retrofit] instance provided by the [networkModule].
     */
    single<RsvpApiService> { get<Retrofit>().create(RsvpApiService::class.java) }

    /** * Provides the [RsvpRepository] as a singleton.
     * Acts as the single source of truth for RSVP data operations,
     * isolating the [RsvpApiService] from the [RsvpViewModel].
     */
    single { RsvpRepository(get()) }

    /** * Provides the [RsvpViewModel] using the [viewModel] DSL.
     * Automatically injects the [RsvpRepository] and ensures state is preserved
     * during Android configuration changes.
     */
    viewModel { RsvpViewModel(get()) }
}