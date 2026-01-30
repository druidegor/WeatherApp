package com.mlechko.weatherapp.presentation.screens.start

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mlechko.weatherapp.data.CityRepositoryImpl
import com.mlechko.weatherapp.data.LocationRepositoryImpl
import com.mlechko.weatherapp.domain.City

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current.applicationContext,
    viewModel: StartViewModel = viewModel {
        StartViewModel(
            cityRepository = CityRepositoryImpl.getInstance(context),
            locationRepository = LocationRepositoryImpl.getInstance(context)
        )
    },
    onGoToMain: () -> Unit,
    onGoToPicker: () -> Unit
) {


    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.load()
        } else {
            onGoToPicker()
        }
    }

    LaunchedEffect(Unit) {
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            viewModel.load()

        }
    }

    val state by viewModel.state.collectAsState()

    LaunchedEffect(state) {
        when(state) {
            ScreenState.Loading -> Unit
            is ScreenState.MainScreen -> {
                onGoToMain()
            }
            ScreenState.PickerScreen -> {
                onGoToPicker()
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }

}