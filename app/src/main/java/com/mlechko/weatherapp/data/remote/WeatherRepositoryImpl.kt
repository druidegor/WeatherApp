package com.mlechko.weatherapp.data.remote

import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.WeatherRepository
import com.mlechko.weatherapp.domain.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApiService
): WeatherRepository {

    private val API_KEY = "38d370f5b965a31f95aff5e5e0bf9b6f"
    private var cachedWeather: MutableMap<City, Weather> = mutableMapOf()
    override suspend fun getWeather(city: City): Weather {
        return withContext(Dispatchers.IO) {
            cachedWeather[city] ?: weatherApi.getWeather(
                lat = city.lat,
                lon = city.lon,
                apiKey = API_KEY
            ).toDomain().also {
                cachedWeather[city] = it
            }
        }
    }
}