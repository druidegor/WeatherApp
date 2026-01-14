package com.mlechko.weatherapp.presentation

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.components.ForeCastSection
import com.mlechko.weatherapp.presentation.components.Header
import com.mlechko.weatherapp.presentation.components.InfoCard
import com.mlechko.weatherapp.presentation.components.InfoItem
import com.mlechko.weatherapp.presentation.components.WeatherCardWithDate

@Composable
fun MainWeatherScreen(
    modifier: Modifier = Modifier,
    city: City,
    viewModel: MainWeatherViewModel = viewModel {
        MainWeatherViewModel(city)
    }
) {

    val state by viewModel.state.collectAsState()

    when(state) {
        is WeatherScreenState.Loading -> {

        }
        is WeatherScreenState.Content -> {

        }
        is WeatherScreenState.Error -> {

        }
    }




}

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    state: WeatherScreenState.Content
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
            date = state.uiState.currentDate,
            temperature = state.uiState.temperature,
            content = state.uiState.weatherType.name
        )

        Spacer(Modifier.height(16.dp))

        Box {

            InfoCard(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .zIndex(1f),
                info = state.uiState.infoCardUI
            )

            ForeCastSection(
                modifier = Modifier
                    .padding(top = 98.dp)
                    .zIndex(0f),
                hourlyWeather = state.uiState.hourlyWeatherUI
            )
        }
    }
}

