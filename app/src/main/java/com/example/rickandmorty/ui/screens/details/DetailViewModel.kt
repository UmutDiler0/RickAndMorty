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

    fun getCharInfo(id: Int){
        viewModelScope.launch {
            _characterInfo.update {
                val character = mainRepo.getCharacterById(id)
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
            _isResponse.update {
                if(_characterInfo.value == CharacterResponse.empty())
                    false
                else
                    true
            }
        }
    }

    fun getEpisodeInfo(url : String){
        viewModelScope.launch {
            _episodeInfo.update {
                val episode = mainRepo.getEpisodesByUrl(url)
                it.copy(
                    id = episode.id,
                    name = episode.name,
                    episode = episode.episode,
                    url = episode.url,
                    characters = episode.characters,
                    air_date = episode.air_date,
                    created = episode.created,
                )
                _episodeList.update {
                    it.add(episode)
                    it
                }
                it
            }
        }
    }
}