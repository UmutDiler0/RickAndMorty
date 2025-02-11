package com.example.rickandmorty.data.models

data class CharacterResponse(
    var id: Int,
    var name: String,
    var status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    var episode: List<String>,
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
