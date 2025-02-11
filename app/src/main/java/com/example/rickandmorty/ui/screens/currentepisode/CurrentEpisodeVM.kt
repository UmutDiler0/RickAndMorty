package com.example.rickandmorty.ui.screens.currentepisode

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.EpisodeResponse
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
class CurrentEpisodeVM @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {

    private var _episodeInfo = MutableStateFlow<EpisodeResponse?>(null)
    val episodeInfo: StateFlow<EpisodeResponse?> get() = _episodeInfo

    private var _episodeCharList = MutableStateFlow<MutableList<CharacterResponse>>(mutableListOf())
    val episodeCharList: StateFlow<MutableList<CharacterResponse>> get() = _episodeCharList

    val isResponse: StateFlow<Boolean> = _episodeCharList.map { it.isNotEmpty() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = false
    )

    fun getCharByEpisode(episodeList: List<String>) {



        viewModelScope.launch {
            val character = episodeList.map { url ->
                async { mainRepo.getCharByEpisode(url) }

            }.awaitAll()

            _episodeCharList.update { character.toMutableList() }
        }
    }

    fun getCharacterById(id: Int) {
        if(_episodeInfo.value != null) return
        viewModelScope.launch {
            viewModelScope.launch {
                val episode = mainRepo.getEpisodeById(id)
                _episodeInfo.value = episode

                if (episode.characters.isNotEmpty()) {
                    getCharByEpisode(episode.characters)
                }
            }
        }
    }
}
