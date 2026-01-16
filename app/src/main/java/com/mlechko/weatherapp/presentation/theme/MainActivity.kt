package com.mlechko.weatherapp.presentation.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.MainWeatherScreen
import com.mlechko.weatherapp.presentation.theme.ui.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainWeatherScreen(
                        Modifier.padding(innerPadding),
                        city = City(
                            lat = 53.9,
                            lon = 27.56,
                            name = "Minsk"
                        )
                    )
                }
            }
        }
    }
}
