package com.example.rickandmorty.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.LoadingDatas

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    characterId: Int?
) {
    val viewModel: DetailViewModel = hiltViewModel()
    LaunchedEffect(Unit) { viewModel.getCharInfo(characterId!!) }
    val charInfo by viewModel.characterInfo.collectAsState()
    val isResponse by viewModel.isResponse.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        DetailImage(charImage = charInfo.image)
        CustomAppBar(
            navController = navController
        )
        CharInfoBoard(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-20).dp),
            character = charInfo,
            viewModel= viewModel,
            isResponse = isResponse,
            navController = navController
        )
    }

}

@Composable
fun DetailImage(
    charImage: String?
) {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.bgimage),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(charImage)
                .crossfade(true)
                .size(Size.ORIGINAL)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = "",
            placeholder = painterResource(R.drawable.ic_search),
            error = painterResource(R.drawable.ic_bookmark_border),
            modifier = Modifier.size(150.dp)
        )
    }


}

@Composable
fun CharInfoBoard(
    modifier: Modifier,
    character: CharacterResponse,
    viewModel: DetailViewModel,
    isResponse: Boolean,
    navController: NavHostController
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        when(isResponse){
            false -> LoadingDatas()
            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = character.name,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth()
                    )
                    TagsList(
                        character
                    )
                    EpisodeList(character,viewModel,navController)
                }
            }
        }
    }
}

@Composable
fun TagsList(
    character: CharacterResponse

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Tags(character.location.name)
            Tags(character.gender)
        }
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Tags(character.species)
            Tags(character.status)
        }

    }

}

@Composable
fun Tags(
    tag: String
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            text = tag,
            modifier = Modifier
                .background(
                    color = Color(ContextCompat.getColor(context, R.color.cardColor))
                )
                .padding(16.dp),
            fontSize = 16.sp
        )
    }

    Spacer(modifier = Modifier.padding(12.dp))
}

@Composable
fun EpisodeList(
    character: CharacterResponse,
    viewModel: DetailViewModel,
    navController: NavHostController
) {
    var episodes = character.episode
    episodes.forEach {
        viewModel.getEpisodeInfo(it)
    }
    val episodeList by viewModel.episodeList.collectAsState()
    episodeList.size

    Column {
        Text(
            text = "Bölümler (${episodes.size})",
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            modifier = Modifier.height(300.dp)
        ) {
            items(episodeList) {episode ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navController.navigate(route = Routes.EPISODE.name)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_person),
                        contentDescription = ""
                    )
                    Column(
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            text = episode.name
                        )
                        Text(
                            text = episode.episode
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow),
                        contentDescription = "",
                    )
                }
                Divider(
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

            }
        }
    }
}

