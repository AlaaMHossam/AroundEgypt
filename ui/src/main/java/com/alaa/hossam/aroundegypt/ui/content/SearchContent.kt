package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.SEARCH_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceListItemComponent

@Composable
fun SearchContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.testTag(SEARCH_CONTENT_TEST_TAG),
        content = {
        items(10) {
            ExperienceListItemComponent(experience = Experience())
        }
    })
}

@Preview
@Composable
private fun SearchContentPreview() {
    SearchContent()
}