package com.example.rickandmorty.ui.screens.currentlocation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.ItemListing
import com.example.rickandmorty.ui.screens.characters.LoadingDatas
import com.example.rickandmorty.ui.screens.currentepisode.CurrentEpisodeVM

@Composable
fun CurrentLocation(
    navController: NavHostController,
    locationId: Int?
){
    val viewModel: CurrentLocationVM = hiltViewModel()
    if(locationId != null)
        viewModel.getLocationById(locationId)

    val location by viewModel.locationInfo.collectAsState()
    LaunchedEffect(Unit) {
        location.residents.forEach {
            viewModel.getCharByLocation(it)
        }
    }

    val charList by viewModel.locationCharList.collectAsState()
    val isResponse by viewModel.isResponse.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = location.name,
            isVisible = true,
            navController = navController
        )
        when(isResponse){
            false -> LoadingDatas()
            else -> {
                ItemListing(
                    navController = navController,
                    route = Routes.LOCATION.name,
                    listOfCharacters = charList
                )
            }
        }

    }
}