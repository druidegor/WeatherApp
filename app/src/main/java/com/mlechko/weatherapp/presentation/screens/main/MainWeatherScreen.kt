package com.mlechko.weatherapp.presentation.screens.main

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.components.main.ForeCastSection
import com.mlechko.weatherapp.presentation.components.main.Header
import com.mlechko.weatherapp.presentation.components.main.InfoCard
import com.mlechko.weatherapp.presentation.components.main.WeatherCardWithDate
import com.mlechko.weatherapp.presentation.theme.ui.CustomIcons

@Composable
fun MainWeatherScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current.applicationContext,
    viewModel: MainWeatherViewModel = viewModel {
        MainWeatherViewModel(context)
    },
    onClick: () -> Unit,
    onPickerScreen: () -> Unit
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier =modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onPickerScreen,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = CustomIcons.AddCity,
                    contentDescription = "Button to picker screen"
                )
            }
        }
    ) { innerPadding ->
        when(val content = state) {
            is WeatherScreenState.Loading -> {

            }
            is WeatherScreenState.Content -> {
                WeatherScreen(
                    modifier = Modifier.padding(innerPadding),
                    state = content,
                    onClick = onClick
                )
            }
            is WeatherScreenState.Error -> {
                Log.d("VM","Error!!")
            }
        }
    }






}

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    state: WeatherScreenState.Content,
    onClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header(
            city = state.uiState.cityName,
            time = state.uiState.currentTime
        )

        Spacer(Modifier.height(24.dp))

        WeatherCardWithDate(
            icon = state.uiState.iconInfo,
            date = state.uiState.currentDate,
            temperature = state.uiState.temperature,
            description = state.uiState.description
        )

        Spacer(Modifier.height(16.dp))

        Box(
        ) {

            InfoCard(
                modifier = Modifier
                    .padding(top = 16.dp, start = 32.dp, end = 32.dp)
                    .zIndex(1f),
                info = state.uiState.infoCardUI
            )

            ForeCastSection(
                modifier = Modifier
                    .padding(top = 96.dp, bottom = 4.dp)
                    .zIndex(0f),
                hourlyWeather = state.uiState.hourlyWeatherUI,
                onClick = onClick
            )
        }
    }
}

