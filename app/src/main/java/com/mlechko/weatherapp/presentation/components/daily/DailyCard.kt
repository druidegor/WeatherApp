package com.mlechko.weatherapp.presentation.components.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.model.DailyWeatherUI

@Composable
fun DailyCard(
    modifier: Modifier = Modifier,
    days: List<DailyWeatherUI>
) {
    Box(
        modifier = modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0x90FFFFFF))
        ) {

        }
        Column(
            modifier = Modifier
                .offset(y = 16.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(32.dp)
        ) {
            Text(
                text = stringResource(R.string.future_weather),
                fontWeight = FontWeight.Black,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )

            Spacer(Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(
                    items = days,
                    key = { it.time }
                ) {day ->
                    DailyCardItem(
                        dayInfo = day
                    )
                    Divider()
                }
            }
        }
    }

}