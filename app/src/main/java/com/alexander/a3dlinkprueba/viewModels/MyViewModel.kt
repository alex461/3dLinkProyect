package com.alexander.a3dlinkprueba.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexander.a3dlinkprueba.models.ModelCharacter
import com.alexander.a3dlinkprueba.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val repository: Repository): ViewModel() {


    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    var characterList: Flow<List<ModelCharacter>> = repository.retro

    fun listCharacter() {
        repository.getCharacterByPage()
    }


}