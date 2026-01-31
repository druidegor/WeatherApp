package com.mlechko.weatherapp.data.cities

import com.google.gson.annotations.SerializedName

data class CityDto (
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("name") val name: String
)


