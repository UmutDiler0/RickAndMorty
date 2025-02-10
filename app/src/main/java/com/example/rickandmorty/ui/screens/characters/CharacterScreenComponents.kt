package com.example.rickandmorty.ui.screens.characters


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.example.rickandmorty.R
import com.example.rickandmorty.data.models.CharacterResponse

@Composable
fun SearchBarComponent(
){
    var query by remember {mutableStateOf("")}
    val context = LocalContext.current
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
                contentDescription = "",
                tint = Color(ContextCompat.getColor(context,R.color.iconColor))
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
fun ItemListing(
    navController: NavController,
    route: String,
    listOfCharacters: MutableList<CharacterResponse>
){
    LazyColumn(

    ) {
        items(listOfCharacters){character ->
            CardItem(
                navController = navController,
                route = route,
                character = character
            )
        }
    }
}

@Composable
fun CardItem(
    navController: NavController,
    route: String,
    character: CharacterResponse
){
    val context = LocalContext.current
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate(route+"/${character.id}")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(ContextCompat.getColor(context,R.color.cardColor)
            )
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .size(Size.ORIGINAL)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "",
                placeholder = painterResource(R.drawable.ic_search),
                error = painterResource(R.drawable.ic_bookmark_border),
                modifier = Modifier.size(150.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = character.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                Text(
                    text = "Köken",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = character.location!!.name,
                    fontSize = 16.sp,
                )
                Text(
                    text = "Durum",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = character.status + "-" + character.species,
                    fontSize = 16.sp,
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_bookmark_border),
                contentDescription = "",
                modifier = Modifier.padding(16.dp),
                tint = Color(ContextCompat.getColor(context,R.color.iconColor))
            )

        }
    }
}
