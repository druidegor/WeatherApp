package com.mlechko.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlechko.weatherapp.R
import com.mlechko.weatherapp.presentation.theme.ui.ForecastBottom
import com.mlechko.weatherapp.presentation.theme.ui.ForecastTop


@Preview
@Composable
fun MainWeatherCard(
    modifier: Modifier = Modifier,
    degree: String = "23°",
    content: String = "Moon Cloud Fast Wind"
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(48.dp))
            .background(
                MaterialTheme.colorScheme.primary
            )
            .padding(horizontal = 28.dp,vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.moon_cloud),
            contentDescription = "cloud",
            modifier = Modifier.size(120.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = degree,
            fontWeight = FontWeight.Bold,
            fontSize = 72.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = content,
            fontWeight = FontWeight.Black,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}