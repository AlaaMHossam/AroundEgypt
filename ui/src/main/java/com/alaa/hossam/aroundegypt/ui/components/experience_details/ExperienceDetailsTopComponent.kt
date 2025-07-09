package com.alaa.hossam.aroundegypt.ui.components.experience_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alaa.hossam.aroundegypt.ui.R
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceViewsComponent
import com.alaa.hossam.aroundegypt.ui.detailsTintColor

@Composable
fun ExperienceDetailsTopComponent(
    modifier: Modifier = Modifier,
    coverPhotoUrl: String,
    views: Int
) {
    Box(modifier = modifier.height(285.dp)) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = coverPhotoUrl,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Button(
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.align(Alignment.Center),
            onClick = {},
            content = { Text("EXPLORE NOW", color = detailsTintColor) })
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )
        ExperienceViewsComponent(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(8.dp),
            views = views
        )
        Icon(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            painter = painterResource(R.drawable.icn_images),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Preview
@Composable
private fun ExperienceDetailsTopComponentPreview() {
    ExperienceDetailsTopComponent(coverPhotoUrl = "", views = 100)
}