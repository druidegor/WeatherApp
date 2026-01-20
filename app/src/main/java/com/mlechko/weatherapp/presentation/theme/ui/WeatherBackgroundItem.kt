package com.mlechko.weatherapp.presentation.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherBackgroundItem(
    modifier: Modifier = Modifier,
    isNight: Boolean
) {
    val color = if (isNight) Color(0xFF4B3EAE) else Color(0xFFF5ECEC)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        color,
                        color.copy(alpha =0.95f),
                        color.copy(alpha = 0.95f)
                    )
                )
            )
    )

    BlurredCircle(
        modifier = modifier,
        color = Color(0x80FFFFFF),
        size = 170.dp,
        x = (-110).dp,
        y = 100.dp,
        blur = 220f
    )

    BlurredCircle(
        modifier = modifier,
        color = Color(0x66D4D1F0),
        size = 300.dp,
        x = 100.dp,
        y = (-100).dp,
        blur = 150f
    )
}