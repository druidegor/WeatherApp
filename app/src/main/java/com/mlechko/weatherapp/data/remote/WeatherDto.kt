package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("main") val main : String,
    @SerializedName("description") val description : String,
)
