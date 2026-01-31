package com.mlechko.weatherapp.domain

data class City(
    val lat: Double,
    val lon: Double,
    val name: String = ""
)