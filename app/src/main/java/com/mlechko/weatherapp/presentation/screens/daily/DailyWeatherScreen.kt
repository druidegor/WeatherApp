package com.mlechko.weatherapp.presentation.screens.daily

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.DailyWeather
import com.mlechko.weatherapp.presentation.components.daily.CurrentWeatherCard
import com.mlechko.weatherapp.presentation.components.daily.DailyCard
import com.mlechko.weatherapp.presentation.components.daily.DateCard
import com.mlechko.weatherapp.presentation.theme.ui.DailyBackground
import com.mlechko.weatherapp.presentation.theme.ui.Grey
import com.mlechko.weatherapp.presentation.theme.ui.PurpleGradient


@Composable
fun DailyWeatherScreen(
    modifier: Modifier = Modifier,
    city: City,
    viewModel: DailyViewModel = viewModel {
        DailyViewModel(city)
    },
    onClick: () -> Unit
) {

    val state by viewModel.state.collectAsState()

    when(val content = state) {
        is DailyScreenState.Content -> {
            DailyScreen(
                modifier = modifier,
                state = content,
                onClick = onClick
            )
        }
        DailyScreenState.Error -> {

        }
        DailyScreenState.Loading -> {

        }
    }
}
@Composable
fun DailyScreen(
    modifier: Modifier = Modifier,
    state: DailyScreenState.Content,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {


        DailyBackground(
            modifier = modifier.matchParentSize()
        )


        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 48.dp, horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                DateCard(
                    date = state.uiState.currentDate,
                    onClick = onClick
                )

                Spacer(Modifier.height(48.dp))

                CurrentWeatherCard(
                    temperature = state.uiState.temperature,
                    description = state.uiState.description,
                    iconCode = state.uiState.iconInfo.iconCode
                )

                Spacer(Modifier.height(48.dp))

                DailyCard(
                    days = state.uiState.dailyWeatherUI
                )
            }
        }
    }

}