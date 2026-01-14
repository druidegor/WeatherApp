package com.mlechko.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.model.HourlyWeatherUI
import com.mlechko.weatherapp.presentation.theme.ui.Grey

@Preview
@Composable
fun ForeCastSection(
    modifier: Modifier = Modifier,
    hourlyWeather: List<HourlyWeatherUI>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD4D1F0))
            .padding(horizontal = 16.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Today",
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = Grey
            )
            Text(
                text = "Next 7 days",
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = Grey
            )
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            hourlyWeather.forEach {
                ForeCastItem(
                    modifier = Modifier.weight(1f),
                    image = painterResource(id = R.drawable.cloud_storm),
                    info = it
                )
            }
        }
    }
}