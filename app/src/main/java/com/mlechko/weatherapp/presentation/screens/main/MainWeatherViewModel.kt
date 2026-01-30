package com.mlechko.weatherapp.presentation.screens.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.CityRepositoryImpl
import com.mlechko.weatherapp.data.TestWeatherRepository
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.model.WeatherUIState
import com.mlechko.weatherapp.presentation.model.toWeatherUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainWeatherViewModel(context: Context): ViewModel() {

    private val cityRepository = CityRepositoryImpl.getInstance(context)
    private val repository = TestWeatherRepository

    private val _state = MutableStateFlow<WeatherScreenState>(WeatherScreenState.Loading)

    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {

            try {
                val city = cityRepository.getSavedCity()
                if (city != null) {
                    Log.d("GPS", "ERROR1")
                    val weather = repository.getWeather(city).toWeatherUIState()
                    _state.value = WeatherScreenState.Content(
                        uiState = weather
                    )
                } else _state.value = WeatherScreenState.Error
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

