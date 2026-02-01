package com.mlechko.weatherapp.domain

import kotlinx.coroutines.flow.Flow

interface CityRepository {

    fun getSavedCity(): Flow<List<City>>

    suspend fun saveCity(city: City)

    suspend fun searchCity(query: String): List<City>
}