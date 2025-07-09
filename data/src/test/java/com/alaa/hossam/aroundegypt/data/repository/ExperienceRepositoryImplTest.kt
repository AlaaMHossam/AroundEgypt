package com.alaa.hossam.aroundegypt.data.repository

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ExperienceRepositoryImplTest {

    @Test
    fun when_get_experiences_is_success_then_list_is_returned() {
        // Given
        val experienceRepositoryImpl = ExperienceRepositoryImpl()

        // When

        // Then
        val result = runBlocking { experienceRepositoryImpl.getRecommendedExperiences() }
        assert((result as DataState.Success).data == listOf<Experience>())
    }
}