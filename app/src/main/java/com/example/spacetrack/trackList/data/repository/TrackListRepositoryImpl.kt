package com.example.spacetrack.trackList.data.repository

import com.example.spacetrack.trackList.data.helper.TrackListHelper
import com.example.spacetrack.trackList.domain.model.TrackModel
import com.example.spacetrack.trackList.domain.repository.SpaceTrackRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TrackListRepositoryImpl(private val trackListHelper: TrackListHelper) :  SpaceTrackRepository{

    override suspend fun getTrackList(): Flow<List<TrackModel>> =
        withContext(context = Dispatchers.IO) {
            trackListHelper.getTrackList()
        }
}