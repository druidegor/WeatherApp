package com.mlechko.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.presentation.theme.ui.WhiteTextOnSecondaryCard

@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    image: Painter,
    content: String,
    title: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "image"
        )
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = content,
            fontSize = 9.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.onSecondary.copy(0.5f)
        )
    }
}