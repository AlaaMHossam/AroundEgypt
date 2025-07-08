package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceListItemComponent

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            // Title & Description
            Text(text = "Welcome!")
            Text(text = "Now you can explore any experience in 360 degrees and get all the details about it all in one place.")
        }
        item {
            Spacer(Modifier.height(32.dp))
            Text(text = "Recommended Experiences")
            Spacer(Modifier.height(8.dp))
        }
        item {
            LazyRow {
                items(10) {
                    ExperienceListItemComponent()
                }
            }
        }

        item {
            Spacer(Modifier.height(32.dp))
            Text(text = "Most Recent")
            Spacer(Modifier.height(8.dp))
        }

        items(10) {
            ExperienceListItemComponent()
        }
    }
}

@Preview
@Composable
private fun HomeContentPreview() {
    HomeContent()
}