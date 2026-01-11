package com.mlechko.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.TestWeatherRepository
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.CurrentWeather
import com.mlechko.weatherapp.domain.HourlyWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainWeatherViewModel(city: City): ViewModel() {

    private val repository = TestWeatherRepository

    private val _state = MutableStateFlow<WeatherScreenState>(WeatherScreenState.Loading)

    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {
            try {
                val weather = repository.getWeather(city)
                _state.value = WeatherScreenState.Content(
                    city = weather.city,
                    currentWeather = weather.currentWeather,
                    hourlyWeather = weather.hourlyWeather
                )
            } catch (e: Exception) {
                _state.value = WeatherScreenState.Error
            }
        }


    }
}
sealed interface WeatherScreenState {

    data object Loading: WeatherScreenState

    data class Content(
        val city: City,
        val currentWeather: CurrentWeather,
        val hourlyWeather: List<HourlyWeather>,
    ): WeatherScreenState

    data object Error: WeatherScreenState
}

