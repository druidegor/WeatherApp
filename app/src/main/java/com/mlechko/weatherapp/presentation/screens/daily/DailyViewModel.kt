package com.mlechko.weatherapp.presentation.screens.daily

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
class DailyViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
): ViewModel() {
    val _state = MutableStateFlow<DailyScreenState>(DailyScreenState.Loading)
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {

            try {
                cityRepository.getSavedCity().collect {
                    if (!it.isEmpty()) {
                        val weather = weatherRepository.getWeather(it.first()).toWeatherUIState()
                        _state.value = DailyScreenState.Content(weather)
                    }
                    else _state.value = DailyScreenState.Error
                }

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