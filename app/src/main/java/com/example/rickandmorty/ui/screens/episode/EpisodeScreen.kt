package com.example.rickandmorty.ui.screens.episode


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.common.component.ListOfEpisodeAndLocations
@Composable
fun EpisodeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(-1f),
        contentAlignment = Alignment.TopStart
    ) {
        // Arkaplan resmi
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )

        // Üst AppBar
        CustomAppBar(
            title = "Bölümler"
        )
    }

    // Liste
    ListOfEpisodeAndLocations()
}

@Preview(
    showSystemUi = true
)
@Composable
fun ShowUi(){
    EpisodeScreen()
}