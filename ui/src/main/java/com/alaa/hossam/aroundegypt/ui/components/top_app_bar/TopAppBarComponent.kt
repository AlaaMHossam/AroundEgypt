package com.alaa.hossam.aroundegypt.ui.components.top_app_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit,
    onCloseSearch: () -> Unit,
    shouldShowCloseButton: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        IconButton(
            onClick = {},
            content = {
                Icon(
                    painter = painterResource(R.drawable.icn_menu),
                    contentDescription = null
                )
            })
        SearchBarComponent(
            modifier = Modifier.weight(1f),
            onSearchClick = onSearchClick,
            onCloseSearch = onCloseSearch,
            shouldShowCloseButton = shouldShowCloseButton
        )
        IconButton(
            onClick = {},
            content = {
                Icon(
                    painter = painterResource(R.drawable.icn_filter),
                    contentDescription = null
                )
            })
    }
}

@Preview
@Composable
private fun TopAppBarComponentPreview() {
    TopAppBarComponent(onSearchClick = {}, onCloseSearch = {}, shouldShowCloseButton = false)
}