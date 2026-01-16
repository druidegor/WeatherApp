package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class CurrentDto(
    @SerializedName("dt") val dt : Int,
    @SerializedName("temp") val temp : Double,
    @SerializedName("pressure") val pressure : Int,
    @SerializedName("humidity") val humidity : Int,
    @SerializedName("visibility") val visibility : Int,
    @SerializedName("wind_speed") val wind_speed : Double,
    @SerializedName("weather") val weather : List<WeatherDto>
)
