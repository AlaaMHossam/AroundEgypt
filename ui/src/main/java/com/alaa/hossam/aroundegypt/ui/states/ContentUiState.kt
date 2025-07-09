package com.alaa.hossam.aroundegypt.ui.states

sealed class ContentUiState {
    object Home : ContentUiState()
    object Search : ContentUiState()
}