package com.mlechko.weatherapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {

    @Query("SELECT *FROM city LIMIT 1")
    suspend fun getCity(): CityDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(city: CityDbModel)

    @Query("DELETE FROM city")
    suspend fun deleteCity()
}