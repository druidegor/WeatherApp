package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeather(city: City): Weather
}