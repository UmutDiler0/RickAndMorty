package com.example.rickandmorty.ui.screens.characters


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent(
){
    var query by remember {mutableStateOf("")}
    OutlinedTextField(
        value = query,
        onValueChange = { newText ->
            query = newText
        },
        label = {
            Text(
                text = "Karakter Ara"
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = ""
            )
        },
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = {
                TODO("Call submşt query func")
            }
        ),
    )
}

@Composable
fun CardItem(

){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier.width(100.dp)
                    .height(150.dp)
            )
            Column(
                modifier = Modifier.padding(end = 64.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Rick Sanchez",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Köken",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Earth - (C137)",
                    fontSize = 16.sp,
                )
                Text(
                    text = "Durum",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "Yaşıyor - İnsan",
                    fontSize = 16.sp,
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_bookmark_border),
                contentDescription = "",
                modifier = Modifier.padding(16.dp)

            )
        }
    }
}


@Composable
@Preview(
    showBackground = true
)
fun ShowComponents(){
    CardItem()
}