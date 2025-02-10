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

    fun getCharInfo(id: Int){
        viewModelScope.launch {
            _characterInfo.update {
                mainRepo.getCharacterById(id)
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
                it.copy(
                    id = mainRepo.getEpisodesByUrl(url).id,
                    name = mainRepo.getEpisodesByUrl(url).name,
                    episode = mainRepo.getEpisodesByUrl(url).episode,
                    url = mainRepo.getEpisodesByUrl(url).url,
                    characters = mainRepo.getEpisodesByUrl(url).characters,
                    air_date = mainRepo.getEpisodesByUrl(url).air_date,
                    created = mainRepo.getEpisodesByUrl(url).created,
                )
            }
        }
    }
}