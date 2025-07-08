package com.alaa.hossam.aroundegypt.ui

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class AroundEgyptViewModelTest {

    private val mockGetRecommendedExperiencesUseCase =
        mockk<GetRecommendedExperiencesUseCase>(relaxed = true)

    @Test
    fun when_started_then_get_recommended_experiences_is_called() {
        // Given

        // When
        AroundEgyptViewModel(mockGetRecommendedExperiencesUseCase)

        // Then
        verify { mockGetRecommendedExperiencesUseCase.invoke() }
    }

    @Test
    fun when_update_recommended_experiences_is_called_then_recommended_experience_state_is_loading() {
        // Given
        val aroundEgyptViewModel = AroundEgyptViewModel(mockGetRecommendedExperiencesUseCase)

        // When
        val recommendedExperienceUiState = aroundEgyptViewModel.recommendedExperienceUiState.value

        // Then
        assert(recommendedExperienceUiState is UiState.Loading)
    }

    @Test
    fun when_get_recommended_experiences_use_case_is_success_then_recommended_experience_state_is_success() {
        // Given
        coEvery { mockGetRecommendedExperiencesUseCase.invoke() } returns DataState.Success(emptyList())
        val aroundEgyptViewModel = AroundEgyptViewModel(mockGetRecommendedExperiencesUseCase)

        // When
        val recommendedExperienceUiState = aroundEgyptViewModel.recommendedExperienceUiState.value

        // Then
        assert(recommendedExperienceUiState is UiState.Success)
    }
}