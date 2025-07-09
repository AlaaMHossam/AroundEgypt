package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository

class GetExperienceUseCase(private val experienceRepository: ExperienceRepository) {
    suspend operator fun invoke(id: String): DataState<Experience> {
        return experienceRepository.getExperience(id)
    }
}