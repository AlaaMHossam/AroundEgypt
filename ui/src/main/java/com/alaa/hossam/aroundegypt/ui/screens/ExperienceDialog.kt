package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.EXPERIENCE_DIALOG_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.content.ExperienceContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    experience: Experience?,
    onFavoriteClick: (String) -> Unit
) {
    ModalBottomSheet(
        modifier = modifier.testTag(EXPERIENCE_DIALOG_TEST_TAG),
        onDismissRequest = { onDismiss() },
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        dragHandle = null,
        content = { ExperienceContent(experience = experience,onFavoriteClick = onFavoriteClick) })
}

@Preview
@Composable
private fun ExperienceDialogPreview() {
    ExperienceDialog(onDismiss = {}, experience = Experience()) {}
}