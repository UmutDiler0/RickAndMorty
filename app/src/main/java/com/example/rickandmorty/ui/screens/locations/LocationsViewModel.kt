package com.example.rickandmorty.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.models.LocationResponse
import com.example.rickandmorty.data.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.isActive
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    val mainRepo: MainRepo
): ViewModel() {

    private var _isResponse = MutableStateFlow<Boolean>(false)
    val isResponse: StateFlow<Boolean> get() = _isResponse
    private var _listOfLocations = MutableStateFlow<MutableList<LocationResponse>>(mutableListOf())
    val listOfLocations: StateFlow<MutableList<LocationResponse>> get() = _listOfLocations

    fun getLocations(){
        viewModelScope.launch{
            _listOfLocations.update {
                mainRepo.getLocations()
            }
            _isResponse.update {
                if(_listOfLocations.value.isEmpty())
                    false
                else
                    true
            }
        }
    }
}