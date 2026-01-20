package com.mlechko.weatherapp.presentation.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.navigation.NavGraph
import com.mlechko.weatherapp.presentation.components.daily.DailyCard
import com.mlechko.weatherapp.presentation.screens.daily.DailyScreen
import com.mlechko.weatherapp.presentation.screens.daily.DailyWeatherScreen
import com.mlechko.weatherapp.presentation.screens.main.MainWeatherScreen
import com.mlechko.weatherapp.presentation.theme.ui.WeatherAppTheme
import com.mlechko.weatherapp.presentation.theme.ui.WeatherBackgroundCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {  innerPadding ->
                    NavGraph(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
