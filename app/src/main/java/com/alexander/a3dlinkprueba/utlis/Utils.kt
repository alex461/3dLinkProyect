package com.alexander.a3dlinkprueba.utlis

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible



    fun <A : Activity> Activity.startNewActivity(activity: Class<A>){
        Intent(this,activity).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    fun View.showHide(){
        Handler(Looper.getMainLooper()).postDelayed({
            visibility = if(!isVisible) View.VISIBLE else View.GONE
        }, 3000)

    }


    fun View.enable(enabled: Boolean){
        isEnabled = enabled
        alpha = if (enabled) 1f else 0.5f
    }


    fun View.verificText(mensaje :String){
        if(mensaje.isEmpty()) error(mensaje)
    }

    fun Context.showToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

