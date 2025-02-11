package com.example.rickandmorty.ui.screens.episode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.LoadingDatas

@Composable
fun ListOfEpisodes(
    navController: NavHostController,
    route: String,
    episodes: MutableList<EpisodeResponse>,
    isResponse: Boolean
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.padding(top = 150.dp))
        ListViewForEpisodes(
            navController = navController,
            route = route,
            episodes = episodes,
            isResponse = isResponse
        )
    }
}

@Composable
fun ListViewForEpisodes(
    navController: NavHostController,
    route: String,
    episodes: MutableList<EpisodeResponse>,
    isResponse: Boolean
){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 62.dp, topEnd = 62.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        when(isResponse){
            false -> LoadingDatas()
            else -> LazyColumn(
                Modifier.fillMaxSize()
                    .weight(1f),
            ) {
                items(episodes){ episode ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                navController.navigate(route = route + "/${episode.id}")
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_location),
                            contentDescription = "",
                            modifier = Modifier.padding(8.dp)
                                .scale(1.5f)
                        )
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = episode.name,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                            Text(
                                text = episode.episode,
                                modifier = Modifier.padding(start = 8.dp),
                                fontWeight = FontWeight.Light
                            )

                        }
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow),
                            contentDescription = ""
                        )
                    }
                    Divider(
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }

        }

    }
}