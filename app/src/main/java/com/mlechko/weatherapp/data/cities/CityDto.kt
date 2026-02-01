package com.mlechko.weatherapp.data.cities

import com.google.gson.annotations.SerializedName

data class CityDto (
    @SerializedName("display_name")
    val displayName: String,

    @SerializedName("lat")
    val lat: String,

    @SerializedName("lon")
    val lon: String
)


