package com.example.rickandmorty.data.models

data class LocationResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
){
    companion object{
        fun empty() = LocationResponse(
            id = 0,
            name = "",
            type = "",
            dimension = "",
            residents = listOf(),
            url = "",
            created = ""
        )
    }
}
