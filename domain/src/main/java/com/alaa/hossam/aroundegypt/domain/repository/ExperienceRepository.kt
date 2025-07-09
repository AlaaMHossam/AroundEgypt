package com.alaa.hossam.aroundegypt.domain.repository

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience

interface ExperienceRepository {
    suspend fun getRecommendedExperiences(): DataState<List<Experience>>
    suspend fun getMostRecentExperiences(): DataState<List<Experience>>
    suspend fun search(searchText: String): DataState<List<Experience>>
    suspend fun getExperience(id: String): DataState<Experience>
}