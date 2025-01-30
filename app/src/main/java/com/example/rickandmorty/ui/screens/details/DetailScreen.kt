package com.example.rickandmorty.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar

@Composable
fun DetailScreen(

) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        DetailImage()
        CustomAppBar(isVisible = false)
    }
}

@Composable
fun DetailImage() {
    Image(
        painter = painterResource(R.drawable.bgimage),
        contentDescription = "",
        modifier = Modifier.fillMaxWidth()
            .height(400.dp),
        contentScale = ContentScale.Crop
    )


}

@Composable
@Preview(
    showBackground = true
)
fun ShowUi() {
    DetailScreen()
}