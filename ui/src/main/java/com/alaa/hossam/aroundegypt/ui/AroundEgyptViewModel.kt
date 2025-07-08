package com.alaa.hossam.aroundegypt.ui

import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AroundEgyptViewModel(private val getRecommendedExperiencesUseCase: GetRecommendedExperiencesUseCase) {

    private val recommendedExperienceMutableUiState =
        MutableStateFlow<UiState<List<Experience>>>(UiState.Initial)
    val recommendedExperienceUiState = recommendedExperienceMutableUiState.asStateFlow()

    init {
        updateRecommendedExperiences()
    }

    private fun updateRecommendedExperiences() {
        recommendedExperienceMutableUiState.update { UiState.Loading }
        getRecommendedExperiencesUseCase.invoke()
    }
}
