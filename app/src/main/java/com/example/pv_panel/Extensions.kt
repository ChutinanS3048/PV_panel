package com.example.pv_panel

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String){
     Toast.makeText(this, message, Toast.LENGTH_LONG )
}

fun String.covertToBath(): String{
    return "$this Bath"
}