package com.example.rickandmorty.data.models

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
){
    companion object {
        fun empty() = CharacterResponse(
            id = 0,
            name = "",
            status = "",
            species = "",
            type = "",
            gender = "",
            origin = Location.empty(), // Varsayılan boş Location nesnesi
            location = Location.empty(), // Varsayılan boş Location nesnesi
            image = "",
            episode = emptyList(),
            url = "",
            created = ""
        )
    }
}
