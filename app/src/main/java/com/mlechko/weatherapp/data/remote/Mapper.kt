package com.mlechko.weatherapp.data.remote

import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CurrentWeather
import com.mlechko.weatherapp.domain.DailyWeather
import com.mlechko.weatherapp.domain.HourlyWeather
import com.mlechko.weatherapp.domain.model.Weather
import com.mlechko.weatherapp.domain.model.WeatherType

fun WeatherResponseDto.toDomain(): Weather {
    return Weather(
        timezone = timezone,
        timezoneOffsetSeconds = timezone_offset,
        currentWeather = current.toCurrentWeather(),
        hourlyWeather = hourly
            .take(12)
            .map { it.toHourlyWeather() },
        dailyWeather = daily
            .take(12)
            .map { it.toDailyWeather() }
        )
}

fun DailyDto.toDailyWeather(): DailyWeather {
    return DailyWeather(
        timestamp = dt.toLong(),
        temp = temp.day,
        iconCode = weather.first().icon
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
        visibility = visibility,
        iconCode = weather.first().icon,
        description = weather.first().description
    )
}

fun HourlyDto.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        timestamp = dt.toLong(),
        temperature = temp,
        type = weather.first().toWeatherType(),
        iconCode = weather.first().icon
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