package com.example.rickandmorty.ui.screens.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.common.component.ListOfEpisodeAndLocations
import com.example.rickandmorty.ui.screens.Routes

@Composable
fun LocationScreen(
    navController: NavHostController
){
    Box(
        modifier = Modifier
    ){
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        CustomAppBar(
            title = "Konumlar",
            navController = navController
        )
    }
    ListOfEpisodeAndLocations(
        navController = navController,
        route = Routes.LOCATION.name
    )
}

@Preview(
    showBackground = true
)
@Composable
fun ShowUi(){
//    LocationScreen()
}