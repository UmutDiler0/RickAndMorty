package com.example.rickandmorty.data.services

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int? = null
    )

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    )

    @GET("location")
    suspend fun getLocation()

    @GET("episode")
    suspend fun getEpisode()

}