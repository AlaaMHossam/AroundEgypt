package com.alaa.hossam.aroundegypt.ui

import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase

class AroundEgyptViewModel(private val getRecommendedExperiencesUseCase: GetRecommendedExperiencesUseCase) {

    init {
        updateRecommendedExperiences()
    }

    private fun updateRecommendedExperiences() {
        getRecommendedExperiencesUseCase.invoke()
    }
}
