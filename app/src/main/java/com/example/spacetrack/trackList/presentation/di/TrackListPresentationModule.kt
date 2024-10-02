package com.example.spacetrack.trackList.presentation.di

import com.example.spacetrack.trackList.presentation.viewmodel.TrackListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val trackListPresentationModule = module {
    viewModelOf(::TrackListViewModel)
}