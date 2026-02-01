package com.mlechko.weatherapp.data.cities

import com.mlechko.weatherapp.domain.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun City.toDbModel(): CityDbModel {
    return CityDbModel(
        lat = lat,
        lon = lon
    )
}

fun List<CityDbModel>.toEntity(): List<City> {
    return map { City(
        lat = it.lat,
        lon = it.lon
    ) }
}

fun Flow<List<CityDbModel>>.toEntities(): Flow<List<City>> {
    return map { it.toEntity() }
}

fun List<CityDto>.toEntities(): List<City> {
    return map {
        val cityName = it.displayName.split(",").first()
        val countryName = it.displayName.split(",").last()
        City(
            lat = it.lat.toDouble(),
            lon = it.lon.toDouble(),
            name = "$cityName, $countryName"
        )
    }
}