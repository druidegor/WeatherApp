package com.mlechko.weatherapp.data.cities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val lat: Double,
    val lon: Double
)
