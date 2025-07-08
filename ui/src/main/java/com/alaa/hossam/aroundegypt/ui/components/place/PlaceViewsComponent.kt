package com.alaa.hossam.aroundegypt.ui.components.place

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.R

@Composable
fun PlaceViewsComponent(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.icn_views),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surface
        )
        Text(
            text = "150",
            color = MaterialTheme.colorScheme.surface
        )
    }
}

@Preview
@Composable
private fun PlaceViewsComponentPreview() {
    PlaceViewsComponent()
}