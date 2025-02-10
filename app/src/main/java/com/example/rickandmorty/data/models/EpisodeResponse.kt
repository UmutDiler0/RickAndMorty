package com.example.rickandmorty.data.models

data class EpisodeResponse(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
){
    companion object {
        fun empty() = EpisodeResponse(
            id = 0,
            name = "",
            air_date = "",
            episode = "",
            characters = emptyList(),
            url = "",
            created = ""
        )
    }
}
