package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.common.component.BottomNav
import com.example.rickandmorty.common.component.CustomAppBar
import com.example.rickandmorty.ui.screens.Routes
import com.example.rickandmorty.ui.screens.characters.CharacterScreen
import com.example.rickandmorty.ui.screens.details.DetailScreen
import com.example.rickandmorty.ui.screens.episode.EpisodeList
import com.example.rickandmorty.ui.screens.favorites.FavoriteScreen
import com.example.rickandmorty.ui.screens.locations.LocationScreen
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNav(navController) },
                    topBar = { CustomAppBar()}
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        NavigationStation(modifier = Modifier.padding(innerPadding), navController)
                    }

                }
            }
        }
    }
}

@Composable
fun NavigationStation(
    modifier: Modifier,
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Routes.CHARACTERS.name) {
        composable(route = Routes.CHARACTERS.name) {
            CharacterScreen()
        }
        composable(route = Routes.FAVORITES.name) {
            FavoriteScreen()
        }
        composable(route = Routes.LOCATIONS.name) {
            LocationScreen()
        }
        composable(route = Routes.EPISODES.name) {
            EpisodeList()
        }
        composable(route = Routes.DETAILS.name) {
            DetailScreen()
        }
    }
}
