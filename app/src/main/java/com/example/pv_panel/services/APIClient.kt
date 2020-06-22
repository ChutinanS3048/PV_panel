package com.example.pv_panel.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    //singleton

    private var retrofit : Retrofit? = null

    fun getClient(): Retrofit{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("http://eb82680ce95e.ngrok.io:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return  retrofit!!
    }

}