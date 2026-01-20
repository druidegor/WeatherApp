package com.mlechko.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class TempDto(
    @SerializedName("day") val day : Double
)
