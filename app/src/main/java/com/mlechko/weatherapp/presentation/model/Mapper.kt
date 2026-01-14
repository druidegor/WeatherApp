package com.mlechko.weatherapp.presentation.model


import com.mlechko.weatherapp.domain.HourlyWeather
import com.mlechko.weatherapp.domain.model.Weather
import com.mlechko.weatherapp.domain.model.WeatherType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


fun Weather.toWeatherUIState(): WeatherUIState {
    val cityTime = formatTime(currentWeather.timestampSeconds,timezoneOffsetSeconds)
    val cityDate = formatDate(currentWeather.timestampSeconds,timezoneOffsetSeconds)
    return WeatherUIState(
        cityName = city.name,
        currentTime = cityTime,
        currentDate = cityDate,
        temperature = "${currentWeather.temperature}°",
        weatherType = currentWeather.type.toWeatherTypeUI(),
        infoCardUI = InfoCardUI(
            "${currentWeather.humidity}%",
            "${currentWeather.windSpeed} km/h",
            "${currentWeather.pressure}hPa",
            "${currentWeather.visibility / 1000} km"
        ),
        hourlyWeatherUI =hourlyWeather.toHourlyWeatherUI(timezoneOffsetSeconds)
    )
}

fun WeatherType.toWeatherTypeUI(): WeatherTypeUi {
    return when(this) {
        WeatherType.CLEAR -> WeatherTypeUi.CLEAR
        WeatherType.CLOUDS -> WeatherTypeUi.CLOUDS
        WeatherType.RAIN -> WeatherTypeUi.RAIN
        WeatherType.STORM -> WeatherTypeUi.STORM
        WeatherType.SNOW -> WeatherTypeUi.SNOW
        WeatherType.FOG -> WeatherTypeUi.FOG
    }
}

fun List<HourlyWeather>.toHourlyWeatherUI(
    offsetTime: Int
): List<HourlyWeatherUI> {
    return map{hourlyWeather ->
        HourlyWeatherUI(
            time = formatHourlyTime(hourlyWeather.timestamp,offsetTime),
            weatherType = hourlyWeather.type.toWeatherTypeUI(),
            temperature = "${hourlyWeather.temperature}°")
    }
}
fun formatTime(utc: Long, offsetTime: Int): String {
    val millis = (utc + offsetTime) * 1000

    val date = Date(millis)
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")

    return formatter.format(date)
}

fun formatHourlyTime(utc: Long, offsetTime: Int): String {
    val millis = (utc + offsetTime) * 1000

    val date = Date(millis)
    val formatter = SimpleDateFormat("HH:00", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")

    return formatter.format(date)
}

fun formatDate(
    utc: Long,
    offsetSeconds: Int
): String {
    val millis = (utc + offsetSeconds) * 1000

    val date = Date(millis)
    val formatter = SimpleDateFormat(
        "EEEE, d MMMM yyyy",
        Locale.ENGLISH
    )
    formatter.timeZone = TimeZone.getTimeZone("UTC")

    return formatter.format(date)
}