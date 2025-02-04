package com.example.rickandmorty.ui.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        SearchBarComponent()
        ItemListing(
            navController = navController,
            route = Routes.DETAILS.name
        )
    }

}