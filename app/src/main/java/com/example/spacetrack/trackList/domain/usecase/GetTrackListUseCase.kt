package com.example.spacetrack.trackList.domain.usecase

import com.example.spacetrack.trackList.domain.model.TrackModel
import com.example.spacetrack.trackList.domain.repository.SpaceTrackRepository
import kotlinx.coroutines.flow.Flow

interface GetTrackListUseCase {

    suspend fun invoke(): Flow<List<TrackModel>>
}

class GetTrackListUseCaseImpl(private val repository: SpaceTrackRepository) : GetTrackListUseCase {

    override suspend fun invoke(): Flow<List<TrackModel>> = repository.getTrackList()
}