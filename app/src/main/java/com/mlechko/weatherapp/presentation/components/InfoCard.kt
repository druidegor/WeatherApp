package com.mlechko.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mlechko.weatherapp.R


@Preview
@Composable
fun InfoCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .shadow(
                elevation =  8.dp,
                shape = RoundedCornerShape(20.dp)
                )
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoItem(
            modifier = Modifier.weight(1f),
            image = painterResource(id = R.drawable.ic_carbon_humidity),
            title = "75%",
            content = "Humidity"
        )
        InfoItem(
            modifier = Modifier.weight(1f),
            image = painterResource(id = R.drawable.ic_tabler_wind),
            title = "8 km/h",
            content = "Wind"
        )
        InfoItem(
            modifier = Modifier.weight(1f),
            image = painterResource(id = R.drawable.ic_speedometer),
            title = "1011",
            content = "Air pressure"
        )
        InfoItem(
            modifier = Modifier.weight(1f),
            image = painterResource(id = R.drawable.ic_round_visibility_),
            title = "6 km",
            content = "Visibility"
        )
    }
}