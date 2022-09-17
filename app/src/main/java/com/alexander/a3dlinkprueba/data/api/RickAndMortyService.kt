package com.alexander.a3dlinkprueba.data.api

import com.alexander.a3dlinkprueba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

   @GET("character")
    suspend fun getCharacter(): RickAndMortyResponse
//     @GET("{username}")
//     fun getCharacter(@Path("username") username: String?):  RickAndMortyResponse
}