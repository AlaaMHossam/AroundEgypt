package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetMostRecentExperiencesUseCaseTest {

    private val mockExperienceRepository = mockk<ExperienceRepository>(relaxed = true)

    @Test
    fun when_invoked_then_get_most_recent_experiences_is_called_in_repository() {
        // Given
        val getMostRecentExperiencesUseCase =
            GetMostRecentExperiencesUseCase(mockExperienceRepository)

        // When
        runBlocking { getMostRecentExperiencesUseCase.invoke() }

        // Then
        coVerify { mockExperienceRepository.getMostRecentExperiences() }
    }
}