package com.example.rickandmorty.data.repository

import android.util.Log
import com.example.rickandmorty.data.models.CharacterResponse
import com.example.rickandmorty.data.models.EpisodeResponse
import com.example.rickandmorty.data.models.LocationResponse
import com.example.rickandmorty.data.services.RickAndMortyApi
import javax.inject.Inject

class MainRepo @Inject constructor(
    val rickAndMortyApi: RickAndMortyApi
) {

    suspend fun getCharacters(): MutableList<CharacterResponse>{

        return try{
            val response = rickAndMortyApi.getCharacters().results.isEmpty()
            if(response){
                mutableListOf()
            }else{
                rickAndMortyApi.getCharacters().results.toMutableList()
            }
        }catch(e: Exception){
            Log.i("TAG","${e}")
            mutableListOf()
        }
    }

    suspend fun getLocations(): MutableList<LocationResponse>{
        return try {
            val response = rickAndMortyApi.getLocation()
            if(response.results.isEmpty()){
                mutableListOf()
            }else{
                rickAndMortyApi.getLocation().results.toMutableList()
            }
        }catch (e: Exception){
            mutableListOf()
        }
    }

    suspend fun getEpisodes(): MutableList<EpisodeResponse>{
        return try{
            val response = rickAndMortyApi.getEpisode().results
            if(response.isEmpty()){
                mutableListOf()
            }else{
                response.toMutableList()
            }
        }catch(e: Exception){
            mutableListOf()
        }
    }

    suspend fun getCharacterById(id: Int): CharacterResponse{
        return rickAndMortyApi.getCharacterById(id)
    }

    suspend fun getEpisodesByUrl(url: String): EpisodeResponse{
        return rickAndMortyApi.getEpisodeByCharacter(url)
    }

    suspend fun getEpisodeById(id: Int): EpisodeResponse{
        return rickAndMortyApi.getEpisodeById(id)
    }

    suspend fun getCharByEpisode(url: String): CharacterResponse{
        return rickAndMortyApi.getCharByEpisode(url)
    }

    suspend fun getCharByLocation(url: String): CharacterResponse{
        return rickAndMortyApi.getCharByLocation(url)
    }

    suspend fun getLocationById(id: Int): LocationResponse = rickAndMortyApi.getLocationById(id)

}