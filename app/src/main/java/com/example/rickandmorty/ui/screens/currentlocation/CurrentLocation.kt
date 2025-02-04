package com.example.rickandmorty.ui.screens.currentlocation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.ItemListing

@Composable
fun CurrentLocation(
    navController: NavHostController,
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = "Earth (C-137)",
            isVisible = true,
            navController = navController
        )
        ItemListing(
            navController = navController,
            route = Routes.LOCATION.name
        )
    }
}