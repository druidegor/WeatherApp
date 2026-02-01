package com.mlechko.weatherapp.data.cities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Query("SELECT *FROM city LIMIT 1")
    fun getCity(): Flow<List<CityDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(city: CityDbModel)

    @Query("DELETE FROM city")
    suspend fun deleteCity()
}