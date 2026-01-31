package com.mlechko.weatherapp.data.cities

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CityFactory {

    private const val BASE_URL = "https://nominatim.openstreetmap.org/"

    fun createCityApi(): CityApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CityApiService::class.java)
    }
}