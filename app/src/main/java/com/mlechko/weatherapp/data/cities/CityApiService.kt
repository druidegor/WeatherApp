package com.mlechko.weatherapp.data.cities

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CityApiService {

    @GET("search")
    suspend fun getCity(
        @Header("User-Agent") userAgent: String = "MyWeatherApp/1.0",
        @Query("q") query: String,
        @Query("format") format: String = "json",
        @Query("limit") limit: Int = 10
    ): List<CityDto>

}