package com.alaa.hossam.aroundegypt.ui.components.experience_list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
fun ExperienceLikesComponent(modifier: Modifier = Modifier, likes: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = likes.toString(), fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Image(
            painter = painterResource(R.drawable.icn_favorite),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ExperienceLikesComponentPreview() {
    ExperienceLikesComponent(likes = 100)

}