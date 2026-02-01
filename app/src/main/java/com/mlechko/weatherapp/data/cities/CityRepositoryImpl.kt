package com.mlechko.weatherapp.data.cities

import android.content.Context
import android.util.Log
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CityRepositoryImpl private constructor(
    context: Context,
): CityRepository {

    private val cityApi = CityFactory.createCityApi()
    private val database = CityDatabase.getInstance(context)
    private val dao = database.cityDao()

    override fun getSavedCity(): Flow<List<City>> {
        return dao.getCity().toEntities()
    }

    override suspend fun saveCity(city: City) {
        Log.d("DB", "Saving city: $city")
        dao.saveCity(city.toDbModel())
    }

    override suspend fun searchCity(query: String): List<City> {
        val city = cityApi.getCity(query=query).toEntities()
        return city
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
                    return CityRepositoryImpl(context).also { instance = it }
                }
            }
        }
    }