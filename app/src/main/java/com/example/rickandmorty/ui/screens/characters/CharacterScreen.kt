package com.example.rickandmorty.ui.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
){

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        CustomAppBar()
        SearchBarComponent()
        ItemListing()
    }

}