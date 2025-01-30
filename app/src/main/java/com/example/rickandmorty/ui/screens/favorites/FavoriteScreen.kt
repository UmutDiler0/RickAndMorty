package com.example.rickandmorty.ui.screens.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.characters.ItemListing

@Composable
fun FavoriteScreen(

){
    Column(
        Modifier.fillMaxSize()
    ) {
        CustomAppBar(title = "Favorilerim")
        ItemListing()
    }
}

@Composable
@Preview(
    showBackground = true
)
fun ShowUi(){
    FavoriteScreen()
}