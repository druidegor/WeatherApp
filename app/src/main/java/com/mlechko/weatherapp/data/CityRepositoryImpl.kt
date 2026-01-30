package com.mlechko.weatherapp.data

import android.content.Context
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CityRepository

class CityRepositoryImpl private constructor(
    context: Context
): CityRepository {

    private val database = CityDatabase.getInstance(context)
    private val dao = database.cityDao()

    override suspend fun getSavedCity(): City? {
        return dao.getCity()?.toEntity()
    }

    override suspend fun saveCity(city: City) {
        dao.saveCity(city.toDbModel())
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