package com.mlechko.weatherapp.data

import com.mlechko.weatherapp.data.remote.ApiFactory
import com.mlechko.weatherapp.data.remote.toDomain
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.WeatherRepository
import com.mlechko.weatherapp.domain.model.Weather

object TestWeatherRepository: WeatherRepository {

    private val api = ApiFactory.createWeatherApi()
    override suspend fun getWeather(city: City): Weather {
        return api.getWeather(
            lat = city.lat,
            lon = city.lon,
            apiKey = "38d370f5b965a31f95aff5e5e0bf9b6f"
        ).toDomain(city)
    }
}