package com.mlechko.weatherapp.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mlechko.weatherapp.presentation.model.HourlyWeatherUI
import com.mlechko.weatherapp.presentation.theme.ui.WeatherBackgroundItem


@Composable
fun ForeCastItem(
    modifier: Modifier = Modifier,
    info: HourlyWeatherUI
) {

    val textColor = if (info.iconInfo.isNight) Color.White else Color.Black
    val backColor = if (info.iconInfo.isNight) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary

    Box(
        modifier = modifier
            .width(120.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherBackgroundItem(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .width(100.dp),
            isNight = info.iconInfo.isNight
        )
            Column(
                modifier = Modifier
                 .width(100.dp)
                 .fillMaxSize()
                .clip(RoundedCornerShape(32.dp))
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
                contentDescription = "Weather cloud",
                modifier = Modifier
                    .size(81.dp)
                    .zIndex(1f)
            )
        }

//    Column(
//        modifier = modifier
//            .clip(RoundedCornerShape(25.dp))
//            .background(
//                MaterialTheme.colorScheme.primary
//            )
//            .padding(horizontal = 8.dp, vertical = 8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(4.dp)
//    ) {
//        Text(
//            text = info.time,
//            fontSize = 12.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = MaterialTheme.colorScheme.secondary
//        )
//        Image(
//            painter = image,
//            contentDescription = "Storm cloud",
//            modifier = Modifier
//                .offset(y = (-8).dp)
//                .size(80.dp)
//                .zIndex(0f)
//        )
//        Text(
//            text = info.temperature,
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Black,
//            color = MaterialTheme.colorScheme.secondary
//        )
//    }
}