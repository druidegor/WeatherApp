package com.mlechko.weatherapp.presentation.components.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.model.DailyWeatherUI
import com.mlechko.weatherapp.presentation.theme.ui.Grey
import com.mlechko.weatherapp.presentation.theme.ui.Grey200

@Composable
fun DailyCardItem(
    modifier: Modifier = Modifier,
    dayInfo: DailyWeatherUI
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
            Image(
                painter = painterResource(id = dayInfo.iconCode),
                contentDescription = "Weather picture",
                modifier = Modifier.size(72.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = dayInfo.temperature,
                    fontWeight = FontWeight.Black,
                    fontSize = 36.sp,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                Spacer(Modifier.width(8.dp))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    val date = dayInfo.time.split(",")
                    Text(
                        text = date[0],
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                    Text(
                        text = date[1],
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 9.sp,
                        color = MaterialTheme.colorScheme.onTertiary.copy(0.4f)
                    )
                }
            }
    }
}