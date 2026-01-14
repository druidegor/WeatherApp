package com.mlechko.weatherapp.presentation.model

data class WeatherUIState(
    val cityName: String,
    val currentTime: String,
    val currentDate: String,
    val temperature: String,
    val weatherType: WeatherTypeUi,
    val infoCardUI: InfoCardUI,
    val hourlyWeatherUI: List<HourlyWeatherUI>
)

data class InfoCardUI (
    val humidity: String,
    val windSpeed: String,
    val pressure: String,
    val visibility: String
)
data class HourlyWeatherUI (
    val time: String,
    val weatherType: WeatherTypeUi,
    val temperature: String
)

enum class WeatherTypeUi(title: String) {
    CLEAR("Clear"),
    CLOUDS("Cloudy"),
    RAIN("Rainy"),
    STORM("Storm"),
    SNOW("Snowy"),
    FOG("Fog")
}

