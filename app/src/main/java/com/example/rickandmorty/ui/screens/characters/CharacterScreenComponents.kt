package com.example.rickandmorty.ui.screens.characters


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        keyboardActions = KeyboardActions(
            onDone = {
                TODO("Call submşt query func")
            }
        )
    )
}


@Composable
@Preview(
    showBackground = true
)
fun ShowComponents(){
    SearchBarComponent()
}