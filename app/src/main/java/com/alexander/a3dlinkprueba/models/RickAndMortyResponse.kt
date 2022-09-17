package com.alexander.a3dlinkprueba.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    val info: Info,
    @SerializedName("results")
    val modelCharacters: List<ModelCharacter>
)