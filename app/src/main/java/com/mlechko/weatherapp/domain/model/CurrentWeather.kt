package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.WeatherType

data class CurrentWeather(
    val temperature: Double,
    val type: WeatherType,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Int,
    val visibility: Int
)
