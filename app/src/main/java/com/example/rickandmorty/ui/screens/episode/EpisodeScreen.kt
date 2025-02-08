package com.example.rickandmorty.ui.screens.episode


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes


@Composable
fun EpisodeScreen(
    navController: NavHostController
) {
    val viewModel: EpisodeViewModel = hiltViewModel()
    LaunchedEffect(Unit) {viewModel.getEpisodes() }
    val listOfEpisodes by viewModel.listOfEpisodes.collectAsState()
    val isResponse by viewModel.isResponse.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(-1f),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )
        CustomAppBar(
            title = "Bölümler",
            navController = navController
        )
    }
    ListOfEpisodes(
        navController = navController,
        route = Routes.EPISODE.name,
        episodes = listOfEpisodes,
        isResponse = isResponse
    )
}
