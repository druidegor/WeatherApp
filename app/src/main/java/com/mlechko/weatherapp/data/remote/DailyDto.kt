package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName
data class DailyDto(
    @SerializedName("dt") val dt: Int,
    @SerializedName("temp") val temp : TempDto,
    @SerializedName("weather") val weather : List<WeatherDto>
)
