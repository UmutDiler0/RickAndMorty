package com.example.rickandmorty.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.data.models.LocationResponse

@Composable
fun ListOfEpisodeAndLocations(
    navController: NavHostController,
    route: String,
    locations: MutableList<LocationResponse>
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.padding(top = 150.dp))
        ListsView(
            navController = navController,
            route = route,
            locations = locations
        )
    }

}



@Composable
fun ListsView(
    navController: NavHostController,
    route: String,
    locations: MutableList<LocationResponse>
){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 62.dp, topEnd = 62.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        LazyColumn(
            Modifier.fillMaxSize()
                .weight(1f),
        ) {
            items(locations){ location ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable {
                            navController.navigate(route = route)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_location),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                            .scale(1.5f)
                    )
                    Column {
                        Text(
                            text = location.name,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = "Tür:" + location.type,
                            modifier = Modifier.padding(start = 8.dp),
                            fontWeight = FontWeight.Light
                        )
                        Text(
                            text = "Kişi Sayısı: ${location.residents.size}",
                            modifier = Modifier.padding(start = 8.dp),
                            fontWeight = FontWeight.Light
                        )

                    }
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

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun ShowUi(){
//    ListOfEpisodeAndLocations()
}