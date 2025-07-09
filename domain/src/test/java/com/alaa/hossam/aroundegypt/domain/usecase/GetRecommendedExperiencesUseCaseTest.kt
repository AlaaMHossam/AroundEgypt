package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Test

class GetRecommendedExperiencesUseCaseTest {

    private val mockExperienceRepository = mockk<ExperienceRepository>(relaxed = true)

    @Test
    fun when_invoked_then_get_recommended_experiences_is_called_in_repository() {
        // Given
        val getRecommendedExperiencesUseCase =
            GetRecommendedExperiencesUseCase(mockExperienceRepository)

        // When
        getRecommendedExperiencesUseCase.invoke()

        // Then
        coVerify { mockExperienceRepository.getRecommendedExperiences() }
    }
}