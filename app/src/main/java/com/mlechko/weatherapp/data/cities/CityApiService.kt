package com.mlechko.weatherapp.data.cities

import retrofit2.http.GET
import retrofit2.http.Query

interface CityApiService {

    @GET("search")
    suspend fun getCity(
        @Query("q") query: String,
        @Query("format") format: String = "json",
        @Query("limit") limit: Int = 10
    ): List<CityDto>

}