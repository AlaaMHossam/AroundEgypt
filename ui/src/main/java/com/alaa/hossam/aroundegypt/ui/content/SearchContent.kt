package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.ui.components.experience_list_item.ExperienceListItemComponent

@Composable
fun SearchContent(modifier: Modifier = Modifier) {
    LazyColumn(content = {
        items(10) {
            ExperienceListItemComponent()
        }
    })
}

@Preview
@Composable
private fun SearchContentPreview() {
    SearchContent()
}