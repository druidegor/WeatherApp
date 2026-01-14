package com.mlechko.weatherapp.presentation.components

import android.health.connect.datatypes.units.Temperature
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Preview
@Composable
fun WeatherCardWithDate(
    date: String,
    temperature: String,
    content: String
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
            Modifier
            .offset(y = (-8).dp),
            temperature = temperature,
            content = content
        )

    }
}