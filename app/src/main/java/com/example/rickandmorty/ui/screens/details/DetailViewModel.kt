package com.example.rickandmorty.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {
    private var _characterInfo = MutableStateFlow<CharacterResponse>(CharacterResponse.empty())
    val characterInfo: StateFlow<CharacterResponse> get() = _characterInfo

    private var _episodeInfo = MutableStateFlow<EpisodeResponse>(EpisodeResponse.empty())
    val episodeInfo: StateFlow<EpisodeResponse> get() = _episodeInfo

    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResponse : StateFlow<Boolean> get() = _isResponse

    private var _episodeList = MutableStateFlow<MutableList<EpisodeResponse>>(mutableListOf())
    val episodeList : StateFlow<MutableList<EpisodeResponse>> get() = _episodeList

    fun getCharInfo(id: Int) {
        viewModelScope.launch {
            val character = mainRepo.getCharacterById(id)

            _characterInfo.update {
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

            _isResponse.value = _characterInfo.value != CharacterResponse.empty()
        }
    }

    fun getEpisodeInfo(url: String) {
        viewModelScope.launch {
            val episode = mainRepo.getEpisodesByUrl(url)

            _episodeInfo.update {
                it.copy(
                    id = episode.id,
                    name = episode.name,
                    episode = episode.episode,
                    url = episode.url,
                    characters = episode.characters,
                    air_date = episode.air_date,
                    created = episode.created
                )
            }

            _episodeList.update { currentList ->
                val newList = currentList.toMutableList()
                newList.add(episode)
                newList
            }
        }
    }

}