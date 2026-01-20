package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.WeatherType

data class DailyWeather(
    val timestamp: Long,
    val temp: Double,
    val iconCode: String

)
