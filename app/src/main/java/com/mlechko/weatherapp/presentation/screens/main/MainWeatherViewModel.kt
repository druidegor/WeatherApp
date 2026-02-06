package com.mlechko.weatherapp.presentation.screens.main


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.domain.CityRepository
import com.mlechko.weatherapp.domain.WeatherRepository
import com.mlechko.weatherapp.presentation.model.WeatherUIState
import com.mlechko.weatherapp.presentation.model.toWeatherUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainWeatherViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
): ViewModel() {


    private val _state = MutableStateFlow<WeatherScreenState>(WeatherScreenState.Loading)

    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {

            try {
                cityRepository.getSavedCity().collect {
                    if (!it.isEmpty()) {
                        val weather = weatherRepository.getWeather(it.first()).toWeatherUIState()
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

