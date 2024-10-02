package com.example.spacetrack.trackList.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacetrack.databinding.FragmentTracksBinding
import com.example.spacetrack.trackList.presentation.viewmodel.TrackListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TracksFragment : Fragment() {

    private lateinit var binding: FragmentTracksBinding
    private val viewModel : TrackListViewModel by viewModel()
    private val adapter = TracksAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTracks()
        viewModel.startTimer()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTracksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter() {
        binding.rvTracks.adapter = adapter
        binding.rvTracks.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.tracksStateFlow.collectLatest {
                adapter.submitList(it)
            }
        }

        lifecycleScope.launch {
            viewModel.timeStateFlow.collectLatest {
                binding.timerTextView.text = it
            }
        }
    }


}