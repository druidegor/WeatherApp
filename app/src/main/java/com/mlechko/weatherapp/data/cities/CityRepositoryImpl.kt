package com.mlechko.weatherapp.data.cities

import android.content.Context
import android.util.Log
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CityRepository

class CityRepositoryImpl private constructor(
    context: Context,
): CityRepository {

    private val cityApi = CityFactory.createCityApi()
    private val database = CityDatabase.getInstance(context)
    private val dao = database.cityDao()

    override suspend fun getSavedCity(): City? {
        val city = dao.getCity()?.toEntity()
        Log.d("DB", "Loaded city: $city")
        return city
    }

    override suspend fun saveCity(city: City) {
        Log.d("DB", "Saving city: $city")
        dao.saveCity(city.toDbModel())
    }

    override suspend fun searchCity(query: String): List<City> {
        return cityApi.getCity(query).map {
            City(
                lat = it.lat,
                lon = it.lon
            )
        }
    }

    companion object {

        private var instance: CityRepositoryImpl? = null

        private val LOCK = Any()

        fun getInstance(context: Context): CityRepositoryImpl {

            instance?.let {
                return it
            }

            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                return CityRepositoryImpl(context).also { instance  = it }
            }
        }
    }
}