package com.alaa.hossam.aroundegypt.ui.components.experience_list_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
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
import com.alaa.hossam.aroundegypt.ui.R

@Composable
fun ExperienceViewsComponent(modifier: Modifier = Modifier, views: Int) {
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
            text = views.toString(),
            color = MaterialTheme.colorScheme.surface,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
private fun ExperienceViewsComponentPreview() {
    ExperienceViewsComponent(views = 100)
}