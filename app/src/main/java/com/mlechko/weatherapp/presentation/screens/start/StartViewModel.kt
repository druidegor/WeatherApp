package com.mlechko.weatherapp.presentation.screens.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.CityRepositoryImpl
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StartViewModel(
    private val cityRepository: CityRepositoryImpl,
    private val locationRepository: LocationRepository
): ViewModel() {

    private val _state = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val state = _state.asStateFlow()

    fun load() {

        viewModelScope.launch {
            val gpsCity = locationRepository.getCityFromGps()

            if (gpsCity != null ) {

                cityRepository.saveCity(gpsCity)
                _state.value = ScreenState.MainScreen

            }
            else {

                val savedCity = cityRepository.getSavedCity()

                    if (savedCity != null) {
                        _state.value = ScreenState.MainScreen
                      } else {
                         _state.value = ScreenState.PickerScreen
                     }
            }
        }
    }

}

sealed interface ScreenState {
    object Loading: ScreenState
    object MainScreen: ScreenState
    object PickerScreen: ScreenState
}