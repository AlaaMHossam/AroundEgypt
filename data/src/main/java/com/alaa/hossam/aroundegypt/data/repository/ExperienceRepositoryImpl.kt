package com.alaa.hossam.aroundegypt.data.repository

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.data.data_source.ExperienceRemoteDataSource
import com.alaa.hossam.aroundegypt.data.model.toDomain
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExperienceRepositoryImpl
@Inject constructor(private val experienceRemoteDataSource: ExperienceRemoteDataSource) :
    ExperienceRepository {

    override suspend fun getRecommendedExperiences(): DataState<List<Experience>> =
        withContext(Dispatchers.IO) {
            try {
                val result = experienceRemoteDataSource.getRecommendedExperiences().experiences
                return@withContext DataState.Success(result.map { it.toDomain() })
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }
        }

    override suspend fun getMostRecentExperiences(): DataState<List<Experience>> =
        withContext(Dispatchers.IO) {
            try {
                val result = experienceRemoteDataSource.getMostRecentExperiences().experiences
                return@withContext DataState.Success(result.map { it.toDomain() })
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }
        }

    override suspend fun search(searchText: String): DataState<List<Experience>> =
        withContext(Dispatchers.IO) {
            try {
                val result = experienceRemoteDataSource.search(searchText).experiences
                return@withContext DataState.Success(result.map { it.toDomain() })
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }
        }

    override suspend fun getExperience(id: String): DataState<Experience> =
        withContext(Dispatchers.IO) {
            try {
                val result = experienceRemoteDataSource.getExperience(id)
                return@withContext DataState.Success(result.experiences.toDomain())
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }

        }

    override suspend fun favoriteExperience(id: String): DataState<Int> =
        withContext(Dispatchers.IO) {
            try {
                val result = experienceRemoteDataSource.favoriteExperience(id)
                return@withContext DataState.Success(result.data)
            } catch (exception: Exception) {
                return@withContext DataState.Error(exception.message ?: "Unknown Error")
            }
        }
}