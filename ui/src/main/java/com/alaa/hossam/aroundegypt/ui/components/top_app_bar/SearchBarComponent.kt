package com.alaa.hossam.aroundegypt.ui.components.top_app_bar

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.ui.CLEAR_SEARCH_BUTTON_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.R
import com.alaa.hossam.aroundegypt.ui.SEARCH_FIELD_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.searchBgColor

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit,
    onCloseSearch: () -> Unit,
    shouldShowCloseButton: Boolean
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember { mutableStateOf("") }

    TextField(
        modifier = modifier.testTag(SEARCH_FIELD_TEST_TAG),
        value = searchText,
        onValueChange = { searchText = it },
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
        },
        trailingIcon = {
            if (shouldShowCloseButton)
                IconButton(
                    modifier = Modifier.testTag(CLEAR_SEARCH_BUTTON_TEST_TAG),
                    onClick = {
                        searchText = ""
                        onCloseSearch()
                    },
                    content = {
                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_close_clear_cancel),
                            contentDescription = null
                        )
                    }
                )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardController?.hide()
            onSearchClick(searchText)
        })
    )
}

@Preview
@Composable
private fun SearchBarComponentPreview() {
    SearchBarComponent(onSearchClick = {}, onCloseSearch = {}, shouldShowCloseButton = false)
}