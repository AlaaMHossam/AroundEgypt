package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository

class SearchUseCase(private val experienceRepository: ExperienceRepository) {
    suspend operator fun invoke(searchText: String): DataState<List<Experience>> {
        return experienceRepository.search(searchText)
    }
}