package com.alexander.a3dlinkprueba.data.api

import okhttp3.ResponseBody
import retrofit2.Response

sealed class Resourse<out T> {

    data class  Success <out T>(val value: T) :Resourse<T>()

    data class Failure(
        val isNetWorkError: Boolean,
        val errorCode:Int?,
        val errorBody :ResponseBody?
    ) :Resourse<Nothing>()

}