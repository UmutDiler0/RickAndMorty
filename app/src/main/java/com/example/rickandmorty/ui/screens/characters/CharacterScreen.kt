package com.example.rickandmorty.ui.screens.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: CharacterViewModel
){
    val isResponse by viewModel.isResponse.collectAsState()
    val listOfCharacter by viewModel.listOfCharacters.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        if(isResponse){
            SearchBarComponent()
            ItemListing(
                navController = navController,
                route = Routes.DETAILS.name,
                listOfCharacters = listOfCharacter
            )
        }else
            LoadingDatas()

    }

}

@Composable
fun LoadingDatas(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }

}