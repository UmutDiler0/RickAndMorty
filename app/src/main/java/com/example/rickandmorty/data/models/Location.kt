package com.example.rickandmorty.data.models

data class Location(
    val name: String,
    val url: String
){
    companion object{
        fun empty() = Location(
            name = "",
            url = ""
        )
    }
}
