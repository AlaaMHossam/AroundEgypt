package com.alaa.hossam.aroundegypt.domain.usecase

import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SearchUseCaseTest {

    private val mockExperienceRepository = mockk<ExperienceRepository>(relaxed = true)

    @Test
    fun when_invoked_then_search_is_called_in_repository() {
        // Given
        val searchUseCase = SearchUseCase(mockExperienceRepository)

        // When
        runBlocking { searchUseCase.invoke("test") }

        // Then
        coVerify { mockExperienceRepository.search("test") }
    }
}