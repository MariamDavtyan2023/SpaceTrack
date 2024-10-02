package com.example.spacetrack

import android.app.Application
import com.example.spacetrack.trackList.data.di.trackListDataModule
import com.example.spacetrack.trackList.domain.di.trackListDomainModule
import com.example.spacetrack.trackList.presentation.di.trackListPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpaceTrackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SpaceTrackApplication)
            modules(trackListDomainModule, trackListDataModule, trackListPresentationModule)
        }
    }
}