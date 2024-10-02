package com.example.spacetrack.trackList.presentation.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.spacetrack.R
import com.example.spacetrack.trackList.domain.model.TrackModel
import com.example.spacetrack.databinding.TrackItemBinding

class TracksAdapter : ListAdapter<TrackModel, TrackItemViewHolder>(TrackItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackItemViewHolder {
        val binding = DataBindingUtil.inflate<TrackItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.track_item,
            parent,
            false
        )
        return TrackItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackItemViewHolder, position: Int) {
        val trackItem = getItem(position)
        with(holder.binding) {
            tvMissionNameData.text = trackItem.missionName
            tvDateData.text = trackItem.date
            tvDetailsData.text = trackItem.details
            tvStatusData.text = trackItem.status
        }
    }
}