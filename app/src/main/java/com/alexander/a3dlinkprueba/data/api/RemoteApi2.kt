package com.alexander.a3dlinkprueba.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteApi2 {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RickAndMortyService::class.java)

}