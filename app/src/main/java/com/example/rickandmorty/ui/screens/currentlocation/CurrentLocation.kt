package com.example.rickandmorty.ui.screens.currentlocation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
) {
    val viewModel: CurrentLocationVM = hiltViewModel()

    LaunchedEffect(locationId) {
        locationId?.let {
            viewModel.getLocationById(it)
        }
    }

    val location by viewModel.locationInfo.collectAsState()
    val charList by viewModel.locationCharList.collectAsState()
    val isResponse by viewModel.isResponse.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        location?.let { loc ->
            CustomAppBar(
                title = loc.name ?: "Unknown Location",
                isVisible = true,
                navController = navController
            )
        }


        when {
            !isResponse -> LoadingDatas()
            else -> {
                ItemListing(
                    navController = navController,
                    route = Routes.LOCATION.name,
                    listOfCharacters = charList.toMutableList()
                )
            }
        }
    }
}
