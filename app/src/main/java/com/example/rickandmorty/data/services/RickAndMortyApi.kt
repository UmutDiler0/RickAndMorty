package com.example.rickandmorty.data.services

import com.example.rickandmorty.data.models.ApiResponse
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.data.models.Location
import com.example.rickandmorty.data.models.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int? = null
    ): ApiResponse<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterResponse

    @GET("location")
    suspend fun getLocation(
        @Query("page") page: Int? = null
    ): ApiResponse<LocationResponse>

    @GET("episode")
    suspend fun getEpisode(
        @Query("page") page: Int? = null
    ): ApiResponse<EpisodeResponse>

    @GET
    suspend fun getEpisodeByCharacter(
        @Url url: String
    ): EpisodeResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById (
        @Path("id") id: Int
    ): EpisodeResponse

    @GET
    suspend fun getCharByEpisode(
        @Url url: String
    ): CharacterResponse


}