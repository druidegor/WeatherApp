package com.mlechko.weatherapp.domain

import com.mlechko.weatherapp.domain.model.Weather

class GetWeather(
    val repository: WeatherRepository
) {

    suspend operator fun invoke(city: City): Weather {
        return repository.getWeather(city)
    }
}