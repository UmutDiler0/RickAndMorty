package com.example.rickandmorty.ui.screens.currentepisode

import androidx.compose.runtime.MutableState
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
class CurrentEpisodeVM @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {

    private var _episodeInfo = MutableStateFlow<EpisodeResponse>(EpisodeResponse.empty())
    val episodeInfo: StateFlow<EpisodeResponse> get() = _episodeInfo

    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResposnse: StateFlow<Boolean> get() = _isResponse

    private var _episodeCharacter = MutableStateFlow<CharacterResponse>(CharacterResponse.empty())
    val episodeCharacter: StateFlow<CharacterResponse> get() = _episodeCharacter

    private var _episodeCharList = MutableStateFlow<MutableList<CharacterResponse>>(mutableListOf())
    val episodeCharList: StateFlow<MutableList<CharacterResponse>> get() = _episodeCharList

    fun getCharByEpisode(url: String) {
        viewModelScope.launch {
            val character = mainRepo.getCharByEpisode(url)

            _episodeCharacter.update {
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

            // Listeye karakteri ekle
            _episodeCharList.update { currentList ->
                currentList.toMutableList().apply { add(character) }
            }

            // Bütün karakterler yüklendikten sonra response güncelle
            _isResponse.update { _episodeCharList.value.isNotEmpty() }
        }
    }


    fun getCharacterById(id : Int){
        viewModelScope.launch {
            _episodeInfo.update {
                mainRepo.getEpisodeById(id)
            }

        }
    }

}