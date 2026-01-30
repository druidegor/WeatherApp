package com.mlechko.weatherapp.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.presentation.screens.daily.DailyWeatherScreen
import com.mlechko.weatherapp.presentation.screens.main.MainWeatherScreen
import com.mlechko.weatherapp.presentation.screens.start.StartScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
        modifier = modifier
    ) {
        composable(Screen.Start.route) {
            StartScreen(

                onGoToMain = {
                    navController.navigate(Screen.Main.route)
                },
                onGoToPicker = {
                    navController.navigate(Screen.Main.route)
                }
            )
        }

        composable(Screen.Main.route) {
            MainWeatherScreen(
                onClick = {
                    navController.navigate(Screen.Daily.route)
                }
            )
        }
        composable(Screen.Daily.route) {
            DailyWeatherScreen(
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {

    data object Start: Screen("start")

    data object Main: Screen("main")

    data object Daily: Screen("daily")
}