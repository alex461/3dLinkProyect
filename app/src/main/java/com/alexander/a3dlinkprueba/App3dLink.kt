package com.alexander.a3dlinkprueba

import android.app.Application
import com.alexander.a3dlinkprueba.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App3dLink :Application(){

    private val applicationScope = CoroutineScope(SupervisorJob())
    val repository by lazy { Repository(applicationScope)  }
}