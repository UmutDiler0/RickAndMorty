package com.example.rickandmorty.ui.screens.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.data.models.LocationResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {
    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResponse: StateFlow<Boolean> get() = _isResponse
    private var _listOfEpisodes = MutableStateFlow<MutableList<EpisodeResponse>>(mutableListOf())
    val listOfEpisodes: StateFlow<MutableList<EpisodeResponse>> get() = _listOfEpisodes

    fun getEpisodes(){
        viewModelScope.launch {
            _listOfEpisodes.update {
                mainRepo.getEpisodes()
            }
            _isResponse.update {
                if (_listOfEpisodes.value.isEmpty())
                    false
                else
                    true
            }
        }
    }
}