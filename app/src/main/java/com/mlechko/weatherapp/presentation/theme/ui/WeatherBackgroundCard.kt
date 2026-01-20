package com.mlechko.weatherapp.presentation.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.ui.graphics.asComposeRenderEffect

@Composable
fun WeatherBackgroundCard(
    modifier: Modifier = Modifier,
    isNight: Boolean
) {
    val color = if(isNight) Color(0xFF4B3EAE) else Color(0xFFF5ECEC)

    Box(modifier = modifier
        .fillMaxSize()) {

        // 1. Основной градиент (фон)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            color,
                            color.copy(alpha = 0.965f),
                            color.copy(alpha = 0.965f)
                        )
                    )
                )
        )

        // 2. Белое размытое пятно сверху
        BlurredCircle(
            color = Color(0x80FFFFFF),
            size = 170.dp,
            x = 150.dp,
            y = (-30).dp,
            blur = 220f
        )

        // 3. Голубое размытое пятно слева
        BlurredCircle(
            color = Color(0x66D4D1F0),
            size = 120.dp,
            x = (-100).dp,
            y = 100.dp,
            blur = 220f
        )

    }
}
