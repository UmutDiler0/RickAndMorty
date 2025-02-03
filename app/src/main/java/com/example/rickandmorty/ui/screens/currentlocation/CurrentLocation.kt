package com.example.rickandmorty.ui.screens.currentlocation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmorty.common.component.CustomAppBar

@Composable
fun CurrentLocation(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = "Earth (C-137)",
            isVisible = true
        )
    }
}