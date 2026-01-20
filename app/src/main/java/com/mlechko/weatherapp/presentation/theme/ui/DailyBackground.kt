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
fun DailyBackground(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        // 1. Основной градиент (фон)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF4B3EAE),
                            Color(0xF84B3EAE),
                            Color(0xAB4B3EAE),
                            Color(0x704B3EAE),


                        )
                    )
                )
        ) {
            BlurredCircle(
                color = Color(0xAFFFFFFF),
                size = 300.dp,
                x = -(100).dp,
                y = (-90).dp,
                blur = 220f
            )
            BlurredCircle(
                color = Color(0xAFFFFFFF),
                size = 300.dp,
                x = 200.dp,
                y = (-90).dp,
                blur = 220f
            )
            BlurredCircle(
                color = Color(0xBF4B3EAE),
                size = 300.dp,
                x = 200.dp,
                y = 200.dp,
                blur = 220f
            )
            BlurredCircle(
                color = Color(0xBF4B3EAE),
                size = 300.dp,
                x = (-200).dp,
                y = 200.dp,
                blur = 220f
            )

        }


    }
}
