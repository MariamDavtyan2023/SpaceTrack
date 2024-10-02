package com.example.spacetrack.trackList.data.di


import com.example.spacetrack.trackList.data.helper.TrackListHelper
import com.example.spacetrack.trackList.data.repository.TrackListRepositoryImpl
import com.example.spacetrack.trackList.domain.repository.SpaceTrackRepository
import org.koin.dsl.module

val trackListDataModule = module {
    single { TrackListHelper() }
    single<SpaceTrackRepository> { TrackListRepositoryImpl(get()) }
}
