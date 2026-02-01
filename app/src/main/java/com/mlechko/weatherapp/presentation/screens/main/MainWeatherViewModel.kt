package com.mlechko.weatherapp.presentation.screens.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.cities.CityRepositoryImpl
import com.mlechko.weatherapp.data.remote.TestWeatherRepository
import com.mlechko.weatherapp.presentation.model.WeatherUIState
import com.mlechko.weatherapp.presentation.model.toWeatherUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainWeatherViewModel(context: Context): ViewModel() {

    private val cityRepository = CityRepositoryImpl.getInstance(context)
    private val repository = TestWeatherRepository

    private val _state = MutableStateFlow<WeatherScreenState>(WeatherScreenState.Loading)

    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {

            try {
                cityRepository.getSavedCity().collect {
                    if (!it.isEmpty()) {
                        val weather = repository.getWeather(it.first()).toWeatherUIState()
                        _state.value = WeatherScreenState.Content(
                            uiState = weather
                        )
                        Log.d("DB", "New city list: ${weather.cityName}")
                    }
                    else {
                        _state.value = WeatherScreenState.Error
                    }
                }
            } catch (e: Exception) {
                _state.value = WeatherScreenState.Error
            }
        }
    }
}
sealed interface WeatherScreenState {

    data object Loading: WeatherScreenState

    data class Content(
        val uiState: WeatherUIState
    ): WeatherScreenState

    data object Error: WeatherScreenState
}

