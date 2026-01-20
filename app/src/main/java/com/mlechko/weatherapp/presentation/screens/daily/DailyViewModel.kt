package com.mlechko.weatherapp.presentation.screens.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.TestWeatherRepository
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.model.WeatherUIState
import com.mlechko.weatherapp.presentation.model.toWeatherUIState
import com.mlechko.weatherapp.presentation.screens.main.WeatherScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DailyViewModel(city: City): ViewModel() {

    val repository = TestWeatherRepository

    val _state = MutableStateFlow<DailyScreenState>(DailyScreenState.Loading)
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {

            try {
                val weather = repository.getWeather(city).toWeatherUIState()
                _state.value = DailyScreenState.Content(weather)
            }
            catch(e: Exception) {
                _state.value = DailyScreenState.Error
            }
        }

    }

}

sealed interface DailyScreenState {

    object Loading: DailyScreenState

    class Content(
        val uiState: WeatherUIState
    ): DailyScreenState

    object Error: DailyScreenState
}