package com.mlechko.weatherapp.presentation.model


import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.domain.DailyWeather
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
        iconInfo = IconUI(
            iconCode = currentWeather.iconCode.toIconCode(),
            isNight = currentWeather.iconCode.endsWith("n")
        ),
        cityName = timezone,
        currentTime = cityTime,
        currentDate = cityDate,
        temperature = "${currentWeather.temperature.toInt()}°",
        weatherType = currentWeather.type.toWeatherTypeUI(),
        infoCardUI = InfoCardUI(
            "${currentWeather.humidity}%",
            "${currentWeather.windSpeed} km/h",
            "${currentWeather.pressure}",
            "${currentWeather.visibility / 1000} km"
        ),
        hourlyWeatherUI =hourlyWeather.toHourlyWeatherUI(timezoneOffsetSeconds),
        description = currentWeather.description,
        dailyWeatherUI = dailyWeather.toDailyWeatherUI(timezoneOffsetSeconds)
    )
}

fun String.toIconCode(): Int {
    return when(this) {
        "01d" -> R.drawable.ic_01d
        "01n" -> R.drawable.ic_01n
        "02d" -> R.drawable.ic_02d
        "02n" -> R.drawable.ic_02n
        "03d" -> R.drawable.ic_03dn
        "03n" -> R.drawable.ic_03dn
        "04d" -> R.drawable.ic_04dn
        "04n" -> R.drawable.ic_04dn
        "09d" -> R.drawable.ic_09d
        "09n" -> R.drawable.ic_09n
        "10d" -> R.drawable.ic_10d
        "10n" -> R.drawable.ic_10n
        "11d" -> R.drawable.ic_11dn
        "11n" -> R.drawable.ic_11dn
        "13d" -> R.drawable.ic_13dn
        "13n" -> R.drawable.ic_13dn
        else -> R.drawable.ic_15
    }
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
            iconInfo = IconUI(
                iconCode = hourlyWeather.iconCode.toIconCode(),
                isNight = hourlyWeather.iconCode.endsWith("n")
            ),
            time = formatHourlyTime(hourlyWeather.timestamp,offsetTime),
            weatherType = hourlyWeather.type.toWeatherTypeUI(),
            temperature = "${hourlyWeather.temperature.toInt()}°")
    }
}

fun List<DailyWeather>.toDailyWeatherUI(
    offsetTime: Int
): List<DailyWeatherUI> {
    return map { dailyWeather ->
        DailyWeatherUI(
            iconCode = dailyWeather.iconCode.toIconCode(),
            time = formatDate(utc = dailyWeather.timestamp,offsetTime),
            temperature = "${dailyWeather.temp.toInt()}°"
        )
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