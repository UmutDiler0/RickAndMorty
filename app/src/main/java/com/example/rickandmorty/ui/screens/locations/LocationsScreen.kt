package com.example.rickandmorty.ui.screens.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.common.component.ListOfEpisodeAndLocations

@Composable
fun LocationScreen(

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
            title = "Konumlar"
        )
    }
    ListOfEpisodeAndLocations()
}

@Preview(
    showBackground = true
)
@Composable
fun ShowUi(){
    LocationScreen()
}