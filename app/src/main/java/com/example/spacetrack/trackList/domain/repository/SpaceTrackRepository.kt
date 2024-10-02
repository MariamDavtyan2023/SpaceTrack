package com.example.spacetrack.trackList.domain.repository

import com.example.spacetrack.trackList.domain.model.TrackModel
import kotlinx.coroutines.flow.Flow


interface SpaceTrackRepository {

    suspend fun getTrackList(): Flow<List<TrackModel>>
}