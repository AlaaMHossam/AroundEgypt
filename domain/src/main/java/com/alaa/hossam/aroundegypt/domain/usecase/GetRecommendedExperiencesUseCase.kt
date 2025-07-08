package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience

class GetRecommendedExperiencesUseCase {
    operator fun invoke(): DataState<List<Experience>> {
        return DataState.Success(listOf())
    }
}