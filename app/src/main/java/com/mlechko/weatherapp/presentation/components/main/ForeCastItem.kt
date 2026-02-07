package com.mlechko.weatherapp.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.model.HourlyWeatherUI


@Composable
fun ForeCastItem(
    modifier: Modifier = Modifier,
    info: HourlyWeatherUI
) {

    val textColor = if (info.iconInfo.isNight) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary
    val cardColor = if (info.iconInfo.isNight) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    Box(
        modifier = modifier
            .width(120.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(32.dp))
                    .background(cardColor)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = info.time,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = "${info.temperature}C",
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
                color = textColor
            )
        }
            Image(
                painter = painterResource(id = info.iconInfo.iconCode),
                contentDescription = stringResource(R.string.weather_cloud),
                modifier = Modifier
                    .size(81.dp)
                    .zIndex(1f)
            )
        }

}