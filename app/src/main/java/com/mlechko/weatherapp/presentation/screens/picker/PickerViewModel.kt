@file:OptIn(ExperimentalCoroutinesApi::class)

package com.mlechko.weatherapp.presentation.screens.picker

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlechko.weatherapp.data.cities.CityRepositoryImpl
import com.mlechko.weatherapp.domain.City
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PickerViewModel(context: Context): ViewModel() {

    private val repository = CityRepositoryImpl.getInstance(context)
    private val _state = MutableStateFlow<PickerScreenState>(PickerScreenState())
    val state = _state.asStateFlow()

    private val query = MutableStateFlow("")

    init {
        query
            .onEach {input ->
                _state.update { it.copy(query = input) }
            }
            .flatMapLatest {

                if (it.length < 3) {
                    flow {
                        emit(listOf())
                    }
                } else {
                    flow {
                        try {
                            emit(repository.searchCity(it))
                        } catch (e: Exception) {
                            Log.e("SEARCH", "ERROR", e)
                            emit(emptyList())
                        }
                    }
                }


            }
            .onEach { cities ->
                _state.update { it.copy(cities = cities) }
            }
            .launchIn(viewModelScope)
    }

    fun processCommand(command: PickerScreenCommand) {
        viewModelScope.launch {
            when(command) {
                is PickerScreenCommand.ChooseCity -> {
                    repository.saveCity(command.city)
                    _state.update { it.copy(isSaved = true) }
                }
                is PickerScreenCommand.InputSearchQuery -> {
                    query.update { command.query.trim() }
                }
            }
        }

    }
}

sealed interface PickerScreenCommand {

    data class InputSearchQuery(val query: String): PickerScreenCommand

    data class ChooseCity(val city: City): PickerScreenCommand

}

data class PickerScreenState(
    val query: String = "",
    val cities: List<City> = listOf(),
    val isSaved: Boolean = false
)