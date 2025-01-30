package com.example.rickandmorty.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.characters.CharacterScreen

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier
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
    Box(
        modifier = Modifier.background(color = Color.Transparent),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )
        CharacterImage()
    }
}

@Composable
fun CharacterImage(){
    val context = LocalContext.current
    Image(
        painter = painterResource(R.drawable.ic_search),
        contentDescription = "",
        modifier = Modifier.size(100.dp)
            .clip(shape = CircleShape)
    )
}

@Composable
fun CharInfoBoard(){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
    ) {
        Column {
            Text(text = "Dummy")
        }
    }
}

@Composable
@Preview(
    showBackground = true
)
fun ShowUi() {
    CharInfoBoard()
}