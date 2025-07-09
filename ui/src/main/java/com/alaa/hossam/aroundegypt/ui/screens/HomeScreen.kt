package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alaa.hossam.aroundegypt.ui.AroundEgyptViewModel
import com.alaa.hossam.aroundegypt.ui.components.top_app_bar.TopAppBarComponent
import com.alaa.hossam.aroundegypt.ui.content.HomeContent

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: AroundEgyptViewModel = hiltViewModel()) {

    val recommendedExperiences by viewModel.recommendedExperienceUiState.collectAsStateWithLifecycle()
    val mostRecentExperiences by viewModel.recommendedExperienceUiState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        TopAppBarComponent()
        HomeContent(
            recommendedExperiencesUiState = recommendedExperiences,
            mostRecentExperiencesUiState = mostRecentExperiences
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}