package com.example.rickandmorty.ui.screens

enum class Routes(val route: String) {
    CHARACTERS("home"),
    DETAILS("details/{characterId}"),
    EPISODES("episodes"),
    FAVORITES("favorite"),
    LOCATIONS("locations"),
    EPISODE("episode"),
    LOCATION("location")
}