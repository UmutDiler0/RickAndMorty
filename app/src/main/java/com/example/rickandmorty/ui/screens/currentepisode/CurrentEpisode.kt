package com.example.rickandmorty.ui.screens.currentepisode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.ItemListing

@Composable
fun CurrentEpisode(
    navController: NavHostController,
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = "Bölüm 1 Sezon 2",
            isVisible = true,
            navController = navController
        )
        ItemListing(
            navController = navController,
            route = Routes.EPISODE.name
        )
    }

}
@Preview(
    showBackground = true
)
@Composable
fun ShowUi(){

}