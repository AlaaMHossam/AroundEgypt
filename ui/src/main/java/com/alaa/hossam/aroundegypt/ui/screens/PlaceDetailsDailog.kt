package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.ui.content.ExperienceContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceDialog(modifier: Modifier = Modifier) {
    ModalBottomSheet(
        onDismissRequest = {},
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        dragHandle = null,
        content = { ExperienceContent() })
}

@Preview
@Composable
private fun ExperienceDialogPreview() {
    ExperienceDialog()
}