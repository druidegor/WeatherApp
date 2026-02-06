package com.mlechko.weatherapp.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.presentation.model.IconUI


@Composable
fun MainWeatherCard(
    icon: IconUI,
    modifier: Modifier = Modifier,
    temperature: String,
    description: String
) {
    val textColor = if (icon.isNight) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary
    val cardColor = if (icon.isNight) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary


    Box(
        modifier = modifier
            .width(250.dp)
            .height(290.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(48.dp))
                .background(cardColor)
                .padding(horizontal = 28.dp,vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            Text(
                text = temperature,
                fontWeight = FontWeight.Bold,
                fontSize = 72.sp,
                color = textColor
            )
            Text(
                text = description.uppercase(),
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = textColor
            )
        }
        Image(
            painter = painterResource(id = icon.iconCode),
            contentDescription = "cloud",
            modifier = Modifier
                .offset(y = (-8).dp)
                .size(220.dp)
        )
    }

}