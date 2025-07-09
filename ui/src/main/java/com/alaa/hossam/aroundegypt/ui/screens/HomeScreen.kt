package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
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

    val experience by viewModel.experienceState.collectAsStateWithLifecycle()

    var shouldShowExperienceDialog by remember { mutableStateOf(false) }

    if (shouldShowExperienceDialog)
        ExperienceDialog(
            onDismiss = { shouldShowExperienceDialog = false },
            experience =
                if (experience is UiState.Success<Experience>)
                    (experience as UiState.Success<Experience>).data
                else null,
            onFavoriteClick = { viewModel.addExperienceToFavorites(it) })

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        TopAppBarComponent(
            onSearchClick = {
                viewModel.updateSearchState(it)
                viewModel.updateContentUiState(ContentUiState.Search)
            },
            onCloseSearch = { viewModel.updateContentUiState(ContentUiState.Home) },
            shouldShowCloseButton = contentUiState is ContentUiState.Search
        )

        when (contentUiState) {
            is ContentUiState.Home -> HomeContent(
                recommendedExperiencesUiState = recommendedExperiences,
                mostRecentExperiencesUiState = mostRecentExperiences,
                onExperienceClick = {
                    shouldShowExperienceDialog = true
                    viewModel.updateExperienceState(it)
                }
            )

            is ContentUiState.Search -> SearchContent(
                searchUiState = searchUiState,
                onExperienceClick = { shouldShowExperienceDialog = true })
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}