package com.mlechko.weatherapp.data.remote

import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CurrentWeather
import com.mlechko.weatherapp.domain.HourlyWeather
import com.mlechko.weatherapp.domain.model.Weather
import com.mlechko.weatherapp.domain.model.WeatherType

fun WeatherResponseDto.toDomain(city: City): Weather {
    return Weather(
        city = city,
        timezoneOffsetSeconds = timezone_offset,
        currentWeather = current.toCurrentWeather(),
        hourlyWeather = hourly
            .take(8)
            .map { it.toHourlyWeather() },
        dailyWeather = emptyList()
        )
}

fun CurrentDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        timestampSeconds = dt.toLong(),
        temperature = temp,
        type = weather.first().toWeatherType(),
        humidity = humidity,
        windSpeed = wind_speed,
        pressure = pressure,
        visibility = visibility
    )
}

fun HourlyDto.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        timestamp = dt.toLong(),
        temperature = temp,
        type = weather.first().toWeatherType()
    )
}
fun WeatherDto.toWeatherType(): WeatherType {
    return when(main) {
        "Clear" -> WeatherType.CLEAR
        "Clouds" -> WeatherType.CLOUDS
        "Rain" -> WeatherType.RAIN
        "Thunderstorm" -> WeatherType.STORM
        "Snow" -> WeatherType.SNOW
        "Fog", "Mist", "Haze" -> WeatherType.FOG
        else -> WeatherType.CLEAR
    }
}