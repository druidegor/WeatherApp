package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class HourlyDto(
    @SerializedName("dt") val dt : Int,
    @SerializedName("temp") val temp : Double,
    @SerializedName("weather") val weather : List<WeatherDto>,
)
