package com.example.rickandmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {

    private var _listOfCharacters = MutableStateFlow<MutableList<CharacterResponse>>(mutableListOf())
    val listOfCharacters : StateFlow<MutableList<CharacterResponse>> get() = _listOfCharacters
    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResponse: StateFlow<Boolean> get() = _isResponse

    fun characterList(){
        with(viewModelScope){
            launch {
                _listOfCharacters.update {
                    mainRepo.getCharacters()
                }

            }
            launch {
                _isResponse.update {
                    if (_listOfCharacters.value.isEmpty())
                        false
                    else
                        true
                }
            }

        }

    }
}