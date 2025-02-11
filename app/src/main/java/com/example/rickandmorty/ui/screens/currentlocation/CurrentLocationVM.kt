package com.example.rickandmorty.ui.screens.currentlocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.LocationResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentLocationVM @Inject constructor(
    val mainRepo: MainRepo
) : ViewModel() {

    private var _locationInfo = MutableStateFlow<LocationResponse>(LocationResponse.empty())
    val locationInfo: StateFlow<LocationResponse> get() = _locationInfo

    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResponse: StateFlow<Boolean> get() = _isResponse

    private var _locationCharacter = MutableStateFlow<CharacterResponse>(CharacterResponse.empty())
    val locationCharacter: StateFlow<CharacterResponse> get() = _locationCharacter

    private var _locationCharList = MutableStateFlow<MutableList<CharacterResponse>>(mutableListOf())
    val locationCharList: StateFlow<MutableList<CharacterResponse>> get() = _locationCharList

    fun getCharByLocation(url: String) {
        viewModelScope.launch {
            val character = mainRepo.getCharByLocation(url)

            _locationCharacter.update {
                it.copy(
                    id = character.id,
                    name = character.name,
                    status = character.status,
                    species = character.species,
                    type = character.type,
                    gender = character.gender,
                    origin = character.origin,
                    location = character.location,
                    image = character.image,
                    episode = character.episode,
                    url = character.url,
                    created = character.created
                )
            }

            _locationCharList.update { currentList ->
                currentList.toMutableList().apply { add(character) }
            }

            _isResponse.update { _locationCharList.value.isNotEmpty() }
        }
    }

    fun getLocationById(id: Int) {
        viewModelScope.launch {
            _locationInfo.update {
                mainRepo.getLocationById(id)
            }
        }
    }
}
