package com.example.rickandmorty.ui.screens.currentepisode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.ItemListing
import com.example.rickandmorty.ui.screens.characters.LoadingDatas

@Composable
fun CurrentEpisode(
    navController: NavHostController,
    episodeId: Int?
){
    val viewModel: CurrentEpisodeVM = hiltViewModel()
    if(episodeId != null)
        viewModel.getCharacterById(episodeId)

    val episode by viewModel.episodeInfo.collectAsState()
    episode.characters.forEach {
        viewModel.getCharByEpisode(it)
    }
    val charList by viewModel.episodeCharList.collectAsState()
    val isResponse by viewModel.isResposnse.collectAsState()



    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = episode.episode,
            isVisible = true,
            navController = navController
        )
        when(isResponse){
            false -> LoadingDatas()
            else -> {
                ItemListing(
                    navController = navController,
                    route = Routes.DETAILS.name,
                    listOfCharacters = charList
                )
            }
        }
    }
}
