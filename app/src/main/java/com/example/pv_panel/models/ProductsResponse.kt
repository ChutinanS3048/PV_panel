package com.example.pv_panel.models

data class ProductsResponse(
    val __v: Int,
    val _id: String,
    val current: List<Double>,
    val light_intensity: String,
    val myDateTime: String,
    val nameBoard: String,
    val volts: List<Double>
)