package com.mlechko.weatherapp.presentation.screens.daily

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.cities.CityRepositoryImpl
import com.mlechko.weatherapp.data.remote.TestWeatherRepository
import com.mlechko.weatherapp.presentation.model.WeatherUIState
import com.mlechko.weatherapp.presentation.model.toWeatherUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DailyViewModel(
    context: Context
): ViewModel() {

    val cityRepository = CityRepositoryImpl.getInstance(context)
    val repository = TestWeatherRepository

    val _state = MutableStateFlow<DailyScreenState>(DailyScreenState.Loading)
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {

            try {
                val city = cityRepository.getSavedCity()
                if (city != null) {
                    val weather = repository.getWeather(city).toWeatherUIState()
                    _state.value = DailyScreenState.Content(weather)
                }
               else _state.value = DailyScreenState.Error
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