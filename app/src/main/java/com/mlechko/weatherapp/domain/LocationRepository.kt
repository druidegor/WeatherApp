package com.mlechko.weatherapp.domain

interface LocationRepository {

    suspend fun getCityFromGps(): City?

}