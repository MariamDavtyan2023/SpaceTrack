package com.example.spacetrack.trackList.presentation.screen

import androidx.recyclerview.widget.DiffUtil
import com.example.spacetrack.trackList.domain.model.TrackModel

class TrackItemDiffCallback: DiffUtil.ItemCallback<TrackModel>() {

    override fun areItemsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean {
        return oldItem.missionName == newItem.missionName
    }

    override fun areContentsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean {
        return oldItem == newItem
    }
}