package com.alexander.a3dlinkprueba.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexander.a3dlinkprueba.repository.Repository

class MyViewModelFactory (private  val repositorio: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(repositorio) as T
        }
        throw IllegalArgumentException("View Model Desconocido")}
}