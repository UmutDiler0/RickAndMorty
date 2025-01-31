package com.example.rickandmorty.common.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.screens.Routes

data class BottomNavItem(
    val title: String,
    val icon : Int,
    val route: String
)

@Composable
fun BottomNav(
    navController: NavHostController
){
    val bottomNavList = listOf(
        BottomNavItem("Karakterler", R.drawable.ic_person,Routes.CHARACTERS.name),
        BottomNavItem("Favorilerim", R.drawable.ic_bookmark,Routes.FAVORITES.name),
        BottomNavItem("Konumlar", R.drawable.ic_location,Routes.LOCATIONS.name),
        BottomNavItem("Bölümler", R.drawable.ic_menu,Routes.EPISODES.name)
    )
    BottomAppBar(
        contentColor = Color.Gray,
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavList.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                icon = { Icon(painter = painterResource(screen.icon), contentDescription = "")},
                label = { Text(screen.title)},
                onClick = {
                    if(currentRoute != screen.route){
                        navController.navigate(screen.route){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }

}