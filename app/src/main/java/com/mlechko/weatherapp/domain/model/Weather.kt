package com.mlechko.weatherapp.domain.model

import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CurrentWeather
import com.mlechko.weatherapp.domain.DailyWeather
import com.mlechko.weatherapp.domain.HourlyWeather

data class Weather(
    val timezone: String,
    val timezoneOffsetSeconds: Int,
    val currentWeather: CurrentWeather,
    val dailyWeather: List<DailyWeather>,
    val hourlyWeather: List<HourlyWeather>
)
