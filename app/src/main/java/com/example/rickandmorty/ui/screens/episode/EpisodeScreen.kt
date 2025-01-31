package com.example.rickandmorty.ui.screens.episode


import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmorty.common.component.ListOfEpisodeAndLocations

@Composable
fun EpisodeScreen(){
    ListOfEpisodeAndLocations()
}


@Preview(
    showSystemUi = true
)
@Composable
fun ShowUi(){
    EpisodeScreen()
}