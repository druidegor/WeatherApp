package com.mlechko.weatherapp.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R

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
            contentDescription = stringResource(R.string.image)
        )
        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = content,
            fontSize = 9.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.onTertiary.copy(0.5f)
        )
    }
}