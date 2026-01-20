package com.mlechko.weatherapp.presentation.theme.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val ForecastBottom = Color(0xFF7B6CFF)
val ForecastTop = Color(0xFF4B3EAE)
val White = Color(0xFFFFFFFF)
val WhiteText = Color(0xFFF5F5F5)
val WhiteBackground = Color(0xFFDBD9F2)
val WhiteTextOnSecondaryCard = Color(0xFF6D6D79)
val Grey = Color(0xFF333333)

val Grey200 = Color(0xFFDDDBF3)

val WhiteTertiary = Color(0xFFD4D1F0)


val PurpleGradient = Brush.verticalGradient(
    colors =  listOf(
        ForecastTop,
        ForecastTop.copy(alpha = 0.8f)
    )
)