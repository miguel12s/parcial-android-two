package com.example.parcial_practico_two.utils

import android.content.Context
import android.widget.Toast

class Common {
    companion object{
        fun showToast(context: Context, message:String, duration:Int= Toast.LENGTH_SHORT){
            Toast.makeText(context,message,duration).show()
        }
    }
}