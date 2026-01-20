package com.mlechko.weatherapp.presentation.model

data class WeatherUIState(
    val iconInfo: IconUI,
    val cityName: String,
    val currentTime: String,
    val currentDate: String,
    val description: String,
    val temperature: String,
    val weatherType: WeatherTypeUi,
    val infoCardUI: InfoCardUI,
    val hourlyWeatherUI: List<HourlyWeatherUI>,
    val dailyWeatherUI: List<DailyWeatherUI>
)

data class IconUI (
    val iconCode: Int,
    val isNight: Boolean
)
data class InfoCardUI (
    val humidity: String,
    val windSpeed: String,
    val pressure: String,
    val visibility: String
)
data class HourlyWeatherUI (
    val iconInfo: IconUI,
    val time: String,
    val weatherType: WeatherTypeUi,
    val temperature: String
)

data class DailyWeatherUI(
    val iconCode: Int,
    val time: String,
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

