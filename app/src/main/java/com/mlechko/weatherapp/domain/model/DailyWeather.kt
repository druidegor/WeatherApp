package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.WeatherType

data class DailyWeather(
    val timestamp: Long,
    val minTemp: Double,
    val maxTemp: Double,
    val type: WeatherType

)
