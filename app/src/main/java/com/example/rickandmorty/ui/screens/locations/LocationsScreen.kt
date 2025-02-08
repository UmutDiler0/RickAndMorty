package com.example.rickandmorty.ui.screens.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.LoadingDatas

@Composable
fun LocationScreen(
    navController: NavHostController
) {
    val viewModel: LocationsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.getLocations()
    }
    val listOfLocations by viewModel.listOfLocations.collectAsState()
    val isResponse by viewModel.isResponse.collectAsState()
    Box(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        CustomAppBar(
            title = "Konumlar",
            navController = navController
        )
    }

    ListOfLocations(
        navController = navController,
        route = Routes.LOCATION.name,
        listOfLocations,
        isResponse = isResponse
    )


}
