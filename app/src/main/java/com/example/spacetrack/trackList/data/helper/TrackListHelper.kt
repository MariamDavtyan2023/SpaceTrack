package com.example.spacetrack.trackList.data.helper

import com.example.spacetrack.trackList.domain.model.TrackModel
import kotlinx.coroutines.flow.MutableStateFlow

class TrackListHelper {

    private val _trackList: MutableStateFlow<List<TrackModel>> =
        MutableStateFlow(listOf(
            TrackModel("Mission 1", "10.04.1991", "Details 1", "Success"),
            TrackModel("Mission 2", "10.11.1993", "Details 2", "Success"),
            TrackModel("Mission 3", "10.04.1991", "Details 1", "Success"),
            TrackModel("Mission 4", "10.04.1991", "Details 1", "Success"),
            TrackModel("Mission 5", "10.04.1991", "Details 1", "Success"),
        ))

    fun getTrackList(): MutableStateFlow<List<TrackModel>> {
        return _trackList
    }
}