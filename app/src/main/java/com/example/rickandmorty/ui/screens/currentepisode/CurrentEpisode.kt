package com.example.rickandmorty.ui.screens.currentepisode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.characters.ItemListing

@Composable
fun CurrentEpisode(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = "Bölüm 1 Sezon 2",
            isVisible = true
        )
        ItemListing()
    }

}
@Preview(
    showBackground = true
)
@Composable
fun ShowUi(){
    CurrentEpisode()
}