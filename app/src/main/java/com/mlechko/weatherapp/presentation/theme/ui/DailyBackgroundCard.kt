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
fun DailyBackgroundCard(
    modifier: Modifier = Modifier
){

    Box(
        modifier=modifier
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x10FFFFFF),
                            Color(0xF84B3EAE)
                            )
                    )
                )
        ) {
            BlurredCircle(
                color = Color(0x69B8B8E8),
                size = 500.dp,
                x = (-100).dp,
                y = 0.dp,
                blur = 220f
            )
            BlurredCircle(
                color = Color(0x69B8B8E8),
                size = 500.dp,
                x = 100.dp,
                y = 0.dp,
                blur = 220f
            )



        }
    }
}