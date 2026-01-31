package com.mlechko.weatherapp.domain

interface CityRepository {

    suspend fun getSavedCity(): City?

    suspend fun saveCity(city: City)

    suspend fun searchCity(query: String): List<City>
}