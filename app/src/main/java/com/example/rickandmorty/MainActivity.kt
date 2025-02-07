package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.common.component.BottomNav
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.CharacterScreen
import com.example.rickandmorty.ui.screens.characters.CharacterViewModel
import com.example.rickandmorty.ui.screens.currentepisode.CurrentEpisode
import com.example.rickandmorty.ui.screens.currentlocation.CurrentLocation
import com.example.rickandmorty.ui.screens.details.DetailScreen
import com.example.rickandmorty.ui.screens.episode.EpisodeScreen
import com.example.rickandmorty.ui.screens.favorites.FavoriteScreen
import com.example.rickandmorty.ui.screens.locations.LocationScreen
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.statusBars()) // Durum çubuğunu gizle
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        setContent {
            val currentScreen = remember { mutableStateOf(Routes.CHARACTERS.name) }
            val isTopBarVisible = remember { mutableStateOf(true) }
            val viewModel: CharacterViewModel = hiltViewModel()
            RickAndMortyTheme {
                val navController = rememberNavController()
                isTopBarVisible.value = when (currentScreen.value) {
                    Routes.EPISODES.name -> false
                    Routes.LOCATIONS.name -> false
                    Routes.DETAILS.name -> false
                    Routes.EPISODE.name -> false
                    Routes.LOCATION.name -> false
                    else -> true
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNav(navController) },
                    topBar = {
                        if(isTopBarVisible.value){
                            CustomAppBar(
                                title = when (currentScreen.value) {
                                    Routes.CHARACTERS.name -> "Rick and Morty"
                                    Routes.DETAILS.name -> "Karakter"
                                    Routes.FAVORITES.name -> "Favoriler"
                                    Routes.EPISODES.name -> "Bölümler"
                                    Routes.LOCATIONS.name -> "Konumlar"
                                    else -> ""
                                },
                                isVisible = when (currentScreen.value) {
                                    Routes.EPISODE.name ->true
                                    Routes.LOCATION.name -> true
                                    Routes.DETAILS.name -> true
                                    else -> false
                                },
                                navController = navController
                            )
                        }
                    },
                    containerColor = Color.Transparent
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Routes.CHARACTERS.name,
                        ) {
                            composable(route = Routes.CHARACTERS.name) {
                                LaunchedEffect(Unit) {
                                    currentScreen.value = Routes.CHARACTERS.name
                                    viewModel.characterList()
                                }
                                CharacterScreen(navController = navController,viewModel = viewModel)
                            }
                            composable(route = Routes.FAVORITES.name) {
                                LaunchedEffect(Unit) { currentScreen.value = Routes.FAVORITES.name }
                                FavoriteScreen(navController = navController)
                            }
                            composable(route = Routes.LOCATIONS.name) {
                                LaunchedEffect(Unit) {
                                    currentScreen.value = Routes.LOCATIONS.name

                                }
                                LocationScreen(navController = navController)
                            }
                            composable(route = Routes.EPISODES.name) {
                                LaunchedEffect(Unit) { currentScreen.value = Routes.EPISODES.name }
                                EpisodeScreen(navController = navController)
                            }
                            composable(route = Routes.DETAILS.name) {
                                LaunchedEffect(Unit) { currentScreen.value = Routes.DETAILS.name }
                                DetailScreen(navController = navController)
                            }
                            composable(route = Routes.EPISODE.name) {
                                LaunchedEffect(Unit) { currentScreen.value = Routes.EPISODE.name }
                                CurrentEpisode(navController)
                            }
                            composable(route = Routes.LOCATION.name) {
                                LaunchedEffect(Unit) { currentScreen.value = Routes.LOCATION.name }
                                CurrentLocation(navController)
                            }
                        }
                    }

                }
            }
        }
    }
}


