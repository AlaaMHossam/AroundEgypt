package com.alaa.hossam.aroundegypt.ui.components.top_app_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.ui.R
import com.alaa.hossam.aroundegypt.ui.searchBgColor

@Composable
fun SearchBarComponent(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = searchBgColor,
            unfocusedContainerColor = searchBgColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "\"Try Luxor\"") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.icn_search),
                contentDescription = null
            )
        }
    )
}

@Preview
@Composable
private fun SearchBarComponentPreview() {
    SearchBarComponent()
}