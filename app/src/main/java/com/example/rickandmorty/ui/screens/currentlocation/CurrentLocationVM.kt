package com.example.rickandmorty.ui.screens.currentlocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.LocationResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CurrentLocationVM @Inject constructor(
    val mainRepo: MainRepo
) : ViewModel() {

    private val _locationInfo = MutableStateFlow<LocationResponse?>(null)
    val locationInfo: StateFlow<LocationResponse?> get() = _locationInfo

    private val _locationCharList = MutableStateFlow<List<CharacterResponse>>(emptyList())
    val locationCharList: StateFlow<List<CharacterResponse>> get() = _locationCharList

    val isResponse: StateFlow<Boolean> = _locationCharList.map { it.isNotEmpty() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = false
    )

    fun getLocationById(id: Int) {
        if (_locationInfo.value != null) return

        viewModelScope.launch {
            val location = mainRepo.getLocationById(id)
            _locationInfo.value = location

            if (location.residents.isNotEmpty()) {
                getCharactersByLocation(location.residents)
            }
        }
    }

    private fun getCharactersByLocation(residentUrls: List<String>) {
        viewModelScope.launch {
            val characters = residentUrls.map { url ->
                async { mainRepo.getCharByLocation(url) }
            }.awaitAll()

            _locationCharList.value = characters
        }
    }
}
