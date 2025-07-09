package com.alaa.hossam.aroundegypt.data.repository

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExperienceRepositoryImpl : ExperienceRepository {
    override suspend fun getRecommendedExperiences(): DataState<List<Experience>> =
        withContext(Dispatchers.IO) {
            try {
                return@withContext DataState.Success(listOf())
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }
        }
}