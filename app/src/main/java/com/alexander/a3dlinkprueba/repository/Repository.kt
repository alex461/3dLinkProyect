package com.alexander.a3dlinkprueba.repository

import com.alexander.a3dlinkprueba.data.api.RemoteApi2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow

class Repository(val applicationScope: CoroutineScope) :BaseRepository() {

        val retro =getCharacterByPage()

        fun getCharacterByPage() =flow{
        val request = RemoteApi2.service.getCharacter()
            emit(request.modelCharacters)
    }





}