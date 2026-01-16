package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName


data class WeatherResponseDto (

    @SerializedName("timezone_offset") val timezone_offset : Int,
    @SerializedName("current") val current : CurrentDto,
    @SerializedName("hourly") val hourly : List<HourlyDto>,


)