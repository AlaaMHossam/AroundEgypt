package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository

class FavoriteExperienceUseCase(private val experienceRepository: ExperienceRepository) {
    suspend operator fun invoke(id: String): DataState<Int> {
        return experienceRepository.favoriteExperience(id)
    }
}