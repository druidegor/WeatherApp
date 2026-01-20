package com.mlechko.weatherapp.presentation.components.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mlechko.weatherapp.presentation.model.IconUI

@Composable
fun WeatherCardWithDate(
    icon: IconUI,
    date: String,
    temperature: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DateCard(
            modifier = Modifier
                .zIndex(1f),
            date = date
        )

        MainWeatherCard(
            modifier = Modifier.
                offset(y = (-16).dp),
            icon = icon,
            temperature = temperature,
            description = description
        )

    }
}