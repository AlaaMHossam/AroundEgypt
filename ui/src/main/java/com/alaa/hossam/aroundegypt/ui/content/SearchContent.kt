package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.SEARCH_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceListItemComponent

@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    searchUiState: UiState<List<Experience>>,
    onExperienceClick: (id: String) -> Unit
) {
    when {
        searchUiState is UiState.Loading -> CircularProgressIndicator()
        searchUiState is UiState.Success ->
            if ((searchUiState.data as List<Experience>).isEmpty())
                Text(text = "No results found")
            else
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .testTag(SEARCH_CONTENT_TEST_TAG)
                ) {
                    items(
                        items = searchUiState.data as List<Experience>,
                        key = { experience -> experience.id }
                    ) { experience ->
                        ExperienceListItemComponent(
                            experience = experience,
                            onCLick = onExperienceClick
                        )
                    }
                }

        searchUiState is UiState.Error -> Text(text = searchUiState.message)
    }
}

@Preview
@Composable
private fun SearchContentPreview() {
    SearchContent(
        searchUiState = UiState.Success(List(3) { Experience(id = it.toString()) }),
        onExperienceClick = {})
}