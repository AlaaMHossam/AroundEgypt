package com.alaa.hossam.aroundegypt.ui.components.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.R

@Composable
fun RecommendedListItemComponent(modifier: Modifier = Modifier) {
    Surface(shape = CircleShape, color = Color.Black.copy(alpha = 0.5f)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Image(painterResource(R.drawable.icn_recommended), contentDescription = null)
            Text(text = "Recommended", color = Color.White)
        }
    }
}

@Preview
@Composable
private fun RecommendedListItemComponentPreview() {
    RecommendedListItemComponent()
}