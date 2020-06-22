package com.example.pv_panel.services

import com.example.pv_panel.models.JsonDemoResult
import com.example.pv_panel.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


interface APIService {


    @GET("products")
    fun  getProducts(): Call <List<ProductsResponse>>


}