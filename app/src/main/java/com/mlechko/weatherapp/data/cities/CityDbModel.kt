package com.mlechko.weatherapp.data.cities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityDbModel(
    @PrimaryKey
    val id: Int = 1,
    val lat: Double,
    val lon: Double
)
