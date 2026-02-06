package com.mlechko.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mlechko.weatherapp.presentation.screens.daily.DailyWeatherScreen
import com.mlechko.weatherapp.presentation.screens.main.MainWeatherScreen
import com.mlechko.weatherapp.presentation.screens.picker.PickerScreen
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
                    navController.navigate(Screen.Picker.route)
                }
            )
        }

        composable(Screen.Main.route) {
            MainWeatherScreen(
                onClick = {
                    navController.navigate(Screen.Daily.route) {
                        launchSingleTop = true
                    }
                },
                onPickerScreen = {
                    navController.navigate(Screen.Picker.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Screen.Daily.route) {
            DailyWeatherScreen(
                onClick = {
                    val canGoBack = navController
                        .currentBackStackEntry
                        ?.lifecycle
                        ?.currentState == Lifecycle.State.RESUMED

                    if (canGoBack) {
                        navController.popBackStack()
                    }

                }
            )
        }

        composable(Screen.Picker.route) {
            PickerScreen(
                onBackClick = {
                    val canGoBack = navController
                        .currentBackStackEntry
                        ?.lifecycle
                        ?.currentState == Lifecycle.State.RESUMED

                    if (canGoBack) {
                        navController.popBackStack()
                    }
                },
                onAddClick = {
                    navController.navigate(Screen.Main.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

sealed class Screen(val route: String) {

    data object Start: Screen("start")

    data object Main: Screen("main")

    data object Daily: Screen("daily")

    data object Picker: Screen("picker")
}