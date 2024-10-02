package com.example.spacetrack.trackList.domain.di

import org.koin.core.module.dsl.bind
import com.example.spacetrack.trackList.domain.usecase.GetTrackListUseCase
import com.example.spacetrack.trackList.domain.usecase.GetTrackListUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val trackListDomainModule = module {
    factoryOf(::GetTrackListUseCaseImpl) {bind<GetTrackListUseCase>()}
}