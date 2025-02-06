package com.example.rickandmorty.data.models

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("info") val info: PageInfo,
    @SerializedName("results") val results: List<T>
)
