package com.alexander.a3dlinkprueba.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteApiClass {

    companion object{
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }


    fun <API> build(
        api: Class<API>
    ):API{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}