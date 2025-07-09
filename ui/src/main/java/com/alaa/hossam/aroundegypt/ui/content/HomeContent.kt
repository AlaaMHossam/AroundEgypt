package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.HOME_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceListItemComponent

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    recommendedExperiencesUiState: UiState<List<Experience>>,
    mostRecentExperiencesUiState: UiState<List<Experience>>,
    onExperienceClick: (id: String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .testTag(HOME_CONTENT_TEST_TAG),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Title & Description
            Text(text = "Welcome!", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Now you can explore any experience in 360 degrees and get all the details about it all in one place.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        item {
            Spacer(Modifier.height(32.dp))
            Text(text = "Recommended Experiences", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
        }

        item {
            when {
                recommendedExperiencesUiState is UiState.Loading ->
                    CircularProgressIndicator()

                recommendedExperiencesUiState is UiState.Success ->
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(
                            items = recommendedExperiencesUiState.data as List<Experience>,
                            key = { experience -> experience.id }
                        ) { experience ->
                            ExperienceListItemComponent(
                                experience = experience,
                                onCLick = onExperienceClick
                            )
                        }
                    }

                recommendedExperiencesUiState is UiState.Error ->
                    Text(text = recommendedExperiencesUiState.message)
            }
        }

        item {
            Spacer(Modifier.height(32.dp))
            Text(text = "Most Recent", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
        }


        when {
            mostRecentExperiencesUiState is UiState.Loading ->
                item { CircularProgressIndicator() }

            mostRecentExperiencesUiState is UiState.Success ->
                items(
                    items = mostRecentExperiencesUiState.data as List<Experience>,
                    key = { experience -> experience.id }
                ) { experience ->
                    Spacer(Modifier.height(8.dp))
                    ExperienceListItemComponent(
                        experience = experience,
                        onCLick = onExperienceClick
                    )
                    Spacer(Modifier.height(8.dp))
                }

            mostRecentExperiencesUiState is UiState.Error ->
                item { Text(text = mostRecentExperiencesUiState.message) }
        }
    }
}

@Preview
@Composable
private fun HomeContentPreview() {
    HomeContent(
        recommendedExperiencesUiState = UiState.Initial,
        mostRecentExperiencesUiState = UiState.Initial,
        onExperienceClick = {}
    )
}