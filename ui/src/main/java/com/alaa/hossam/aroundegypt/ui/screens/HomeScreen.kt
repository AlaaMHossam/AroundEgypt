package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.components.top_app_bar.TopAppBarComponent
import com.alaa.hossam.aroundegypt.ui.content.HomeContent

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TopAppBarComponent()
        HomeContent()
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}