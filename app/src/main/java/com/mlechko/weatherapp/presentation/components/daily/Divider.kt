package com.mlechko.weatherapp.presentation.components.daily

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mlechko.weatherapp.presentation.theme.ui.Grey
import com.mlechko.weatherapp.presentation.theme.ui.Grey200

@Composable
fun Divider(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(
        modifier = modifier
            .fillMaxWidth(),
        thickness = 1.dp,
        color = Grey200
    )

}