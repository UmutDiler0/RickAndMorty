package com.example.rickandmorty.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.rickandmorty.R
import com.example.rickandmorty.common.component.CustomAppBar

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        DetailImage() // Arka planda olacak
        CustomAppBar(
            navController = navController
        )
        CharInfoBoard(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Ekranın altında hizala
                .offset(y = (-20).dp) // 50dp yukarı kaydır
        )
    }





}

@Composable
fun DetailImage() {

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
        Image(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .clip(shape = CircleShape)

        )
    }


}

@Composable
fun CharInfoBoard(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Dummy",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )
            TagsList()
            EpisodeList()
        }
    }
}

@Composable
fun TagsList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        items(2) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Tags()
                Tags()
            }

        }
    }
}

@Composable
fun Tags() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            text = "Yaşıyor",
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
    episodeCount: Int = 45
) {
    Column {
        Text(
            text = "Bölümler (${episodeCount})",
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            modifier = Modifier.height(300.dp)
        ) {
            items(10) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
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
                            text = "Bölüm 1 Sezon 2"
                        )
                        Text(
                            text = "Örnek"
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

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun ShowUi() {
//    DetailScreen()
}