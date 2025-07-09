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
import com.alaa.hossam.aroundegypt.ui.content.SearchContent
import com.alaa.hossam.aroundegypt.ui.states.ContentUiState

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: AroundEgyptViewModel = hiltViewModel()) {

    val contentUiState by viewModel.contentUiState.collectAsStateWithLifecycle()

    val recommendedExperiences by viewModel.recommendedExperienceUiState.collectAsStateWithLifecycle()
    val mostRecentExperiences by viewModel.mostRecentExperienceUiState.collectAsStateWithLifecycle()

    val searchUiState by viewModel.searchState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        TopAppBarComponent(onSearchClick = {
            viewModel.updateSearchState(it)
            viewModel.updateContentUiState(ContentUiState.Search)
        })

        when(contentUiState) {
            is ContentUiState.Home -> HomeContent(
                recommendedExperiencesUiState = recommendedExperiences,
                mostRecentExperiencesUiState = mostRecentExperiences
            )
            is ContentUiState.Search -> SearchContent(searchUiState = searchUiState)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}