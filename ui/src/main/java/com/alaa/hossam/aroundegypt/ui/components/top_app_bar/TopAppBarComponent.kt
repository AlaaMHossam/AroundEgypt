package com.alaa.hossam.aroundegypt.ui.components.top_app_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = {},
            content = {
                Icon(
                    painter = painterResource(R.drawable.icn_menu),
                    contentDescription = null
                )
            })
        SearchBarComponent()
    }
}

@Preview
@Composable
private fun TopAppBarComponentPreview() {
    TopAppBarComponent()
}