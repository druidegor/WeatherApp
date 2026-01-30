package com.mlechko.weatherapp.data

import android.util.Log
import com.mlechko.weatherapp.BuildConfig
import com.mlechko.weatherapp.data.remote.ApiFactory
import com.mlechko.weatherapp.data.remote.toDomain
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.WeatherRepository
import com.mlechko.weatherapp.domain.model.Weather

object TestWeatherRepository: WeatherRepository {

    private var cachedWeather: Weather? = null
    private val api = ApiFactory.createWeatherApi()
    override suspend fun getWeather(city: City): Weather {

        cachedWeather?.let {
            return it
        }
        val response =  api.getWeather(
            lat = city.lat,
            lon = city.lon,
            apiKey = "38d370f5b965a31f95aff5e5e0bf9b6f"
        )
        cachedWeather = response.toDomain()
        return response.toDomain()
    }
}