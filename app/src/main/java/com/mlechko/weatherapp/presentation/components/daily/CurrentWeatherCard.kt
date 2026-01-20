package com.mlechko.weatherapp.presentation.components.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.theme.ui.DailyBackgroundCard
import com.mlechko.weatherapp.presentation.theme.ui.PurpleGradient
import com.mlechko.weatherapp.presentation.theme.ui.WeatherBackgroundItem
import com.mlechko.weatherapp.presentation.theme.ui.White

@Preview
@Composable
fun CurrentWeatherCard(
    modifier: Modifier = Modifier,
    temperature: String ,
    description: String ,
    iconCode: Int
)
{

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(40.dp))
            .border(width = 2.dp, color = White,RoundedCornerShape(40.dp))
    ) {
        DailyBackgroundCard(modifier = Modifier.matchParentSize())
        Column (
        ){
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = iconCode),
                    contentDescription = "Weather picture",
                    modifier = Modifier.size(169.dp)
                )
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = temperature,
                        fontWeight = FontWeight.Bold,
                        fontSize = 72.sp,
                        color = White
                    )
                    Text(
                        text = description.uppercase(),
                        fontWeight = FontWeight.Black,
                        fontSize = 13.sp,
                        color = White
                    )
                }
            }
        }
    }


}