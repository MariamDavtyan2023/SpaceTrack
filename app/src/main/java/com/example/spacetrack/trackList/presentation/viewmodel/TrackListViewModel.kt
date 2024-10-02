package com.example.spacetrack.trackList.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetrack.trackList.domain.model.TrackModel
import com.example.spacetrack.trackList.domain.usecase.GetTrackListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Locale

class TrackListViewModel(private val getTrackListUseCase: GetTrackListUseCase) : ViewModel() {

    private val _tracksStateFlow: MutableStateFlow<List<TrackModel>> = MutableStateFlow(emptyList())
    val tracksStateFlow: StateFlow<List<TrackModel>>
        get() = _tracksStateFlow

    private val _timeStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val timeStateFlow : StateFlow<String>
        get() = _timeStateFlow

    fun getTracks() {
        viewModelScope.launch {
            getTrackListUseCase.invoke()
                .catch {
                    // Handle error cases
                }
                .collectLatest {
                    _tracksStateFlow.value = it
                }
        }
    }

    fun startTimer() {
        viewModelScope.launch {
            flow {
                while (true) {
                    emit(java.text.SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()))
                    delay(1000L)
                }
            }.collect { currentTime ->
                _timeStateFlow.value = currentTime
            }
        }
    }
}