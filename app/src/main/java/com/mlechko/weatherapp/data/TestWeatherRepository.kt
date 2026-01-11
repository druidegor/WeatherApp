package com.mlechko.weatherapp.data

import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.WeatherRepository
import com.mlechko.weatherapp.domain.model.Weather

object TestWeatherRepository: WeatherRepository {

    override suspend fun getWeather(city: City): Weather {
        TODO("Not yet implemented")
    }
}