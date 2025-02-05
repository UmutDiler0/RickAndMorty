package com.example.rickandmorty.data.services

import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("/character")
    suspend fun getCharacters()

    @GET("/location")
    suspend fun getLocation()

    @GET("/episode")
    suspend fun getEpisode()

}