package com.example.rickandmorty.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.rickandmorty.R

@Composable
fun ListOfEpisodeAndLocations(

){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BgScreen()
    }
}

@Composable
fun BgScreen(){

}

@Composable
fun ListsView(){

}

@Composable
@Preview(
    showBackground = true
)
fun ShowUi(){
    ListOfEpisodeAndLocations()
}