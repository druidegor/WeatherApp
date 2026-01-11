package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.WeatherType

data class HourlyWeather(
    val timestamp: Long,
    val temperature: Double,
    val type: WeatherType
)
