package com.example.rickandmorty.ui.screens.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.ItemListing

@Composable
fun FavoriteScreen(
    navController: NavHostController
){
    Column(
        Modifier.fillMaxSize()
    ) {
        ItemListing(
            navController = navController,
            route = Routes.DETAILS.name
        )
    }
}

@Composable
@Preview(
    showBackground = true
)
fun ShowUi(){
//    FavoriteScreen()
}