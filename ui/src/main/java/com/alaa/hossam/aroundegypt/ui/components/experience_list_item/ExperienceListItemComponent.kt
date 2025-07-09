package com.alaa.hossam.aroundegypt.ui.components.experience_list_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.R

@Composable
fun ExperienceListItemComponent(modifier: Modifier = Modifier, experience: Experience) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
        ) {
            // Background
            AsyncImage(
                model = experience.coverPhoto,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            // Main content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                if (experience.isRecommended)
                    ExperienceRecommendedComponent(modifier = Modifier.align(Alignment.TopStart))

                Icon(
                    modifier = Modifier.align(Alignment.TopEnd),
                    painter = painterResource(R.drawable.icn_information),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(R.drawable.icn_360),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
                ExperienceViewsComponent(modifier = Modifier.align(Alignment.BottomStart), views = experience.views)
                Icon(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    painter = painterResource(R.drawable.icn_images),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
            }
        }

        // Title & Likes
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)
        ) {
            Text(text = experience.title)
            ExperienceLikesComponent(likes = experience.likes)
        }
    }
}

@Preview
@Composable
private fun ExperienceListItemComponentPreview() {
    ExperienceListItemComponent(experience = Experience())
}