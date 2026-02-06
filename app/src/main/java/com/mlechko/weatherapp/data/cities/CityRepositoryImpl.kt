package com.mlechko.weatherapp.data.cities

import android.util.Log
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val dao: CityDao,
    private val cityApi: CityApiService
): CityRepository {

    override fun getSavedCity(): Flow<List<City>> {
        return dao.getCity().toEntities()
    }

    override suspend fun saveCity(city: City) {
        Log.d("DB", "Saving city: $city")
        dao.saveCity(city.toDbModel())
    }

    override suspend fun searchCity(query: String): List<City> {
        return withContext(Dispatchers.IO) {
            cityApi.getCity(query=query).toEntities()
        }
    }
}