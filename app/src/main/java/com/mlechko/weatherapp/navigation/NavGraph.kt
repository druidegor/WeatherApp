package com.mlechko.weatherapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.screens.daily.DailyWeatherScreen
import com.mlechko.weatherapp.presentation.screens.main.MainWeatherScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        modifier = modifier
    ) {
        composable(Screen.Main.route) {
            MainWeatherScreen(
                city = City(0.0,0.0),
                onClick = {
                    navController.navigate(Screen.Daily.route)
                }
            )
        }
        composable(Screen.Daily.route) {
            DailyWeatherScreen(
                city = City(0.0,0.0),
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {

    data object Main: Screen("main")

    data object Daily: Screen("daily")
}