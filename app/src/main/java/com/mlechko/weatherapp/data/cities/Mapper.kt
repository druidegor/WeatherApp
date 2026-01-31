package com.mlechko.weatherapp.data.cities

import com.mlechko.weatherapp.domain.City

fun City.toDbModel(): CityDbModel {
    return CityDbModel(
        lat = lat,
        lon = lon
    )
}

fun CityDbModel.toEntity(): City {
    return City(
        lat = lat,
        lon = lon    )
}

fun CityDto.toEntity(): City {
    return City(
        lat = lat,
        lon = lon
    )
}