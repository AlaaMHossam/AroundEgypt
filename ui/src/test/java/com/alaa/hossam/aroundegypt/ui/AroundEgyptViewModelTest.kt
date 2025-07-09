package com.alaa.hossam.aroundegypt.ui

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.usecase.GetMostRecentExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AroundEgyptViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val mockGetRecommendedExperiencesUseCase =
        mockk<GetRecommendedExperiencesUseCase>(relaxed = true)

    private val mockGetMostRecentExperiencesUseCase =
        mockk<GetMostRecentExperiencesUseCase>(relaxed = true)

    @Test
    fun when_started_then_get_recommended_experiences_is_called() = runTest {
        // Given

        // When
        AroundEgyptViewModel(
            getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
            getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
        )

        // Then
        advanceUntilIdle()
        coVerify { mockGetRecommendedExperiencesUseCase.invoke() }
    }


    @Test
    fun when_update_recommended_experiences_is_called_then_recommended_experience_state_is_loading() =
        runTest {
            // Given
            val aroundEgyptViewModel = AroundEgyptViewModel(
                getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
                getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
            )
            val collectionList = mutableListOf<UiState<List<Experience>>>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                aroundEgyptViewModel.recommendedExperienceUiState.collect {
                    collectionList.add(it)
                }
            }

            // When
            advanceUntilIdle()
            val result = collectionList[1]

            // Then
            assert(result is UiState.Loading)
        }

    @Test
    fun when_get_recommended_experiences_use_case_is_success_then_recommended_experience_state_is_success() =
        runTest {
            // Given
            coEvery { mockGetRecommendedExperiencesUseCase.invoke() } returns DataState.Success(
                emptyList()
            )
            val aroundEgyptViewModel = AroundEgyptViewModel(
                getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
                getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
            )
            val collectionList = mutableListOf<UiState<List<Experience>>>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                aroundEgyptViewModel.recommendedExperienceUiState.collect {
                    collectionList.add(it)
                }
            }

            // When
            advanceUntilIdle()
            val result = collectionList[2]

            // Then
            assert(result is UiState.Success)
        }

    @Test
    fun when_get_recommended_experiences_use_case_is_error_then_recommended_experience_state_is_error() =
        runTest {
            // Given
            coEvery { mockGetRecommendedExperiencesUseCase.invoke() } returns DataState.Error("Error")
            val aroundEgyptViewModel = AroundEgyptViewModel(
                getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
                getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
            )
            val collectionList = mutableListOf<UiState<List<Experience>>>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                aroundEgyptViewModel.recommendedExperienceUiState.collect {
                    collectionList.add(it)
                }
            }

            // When
            advanceUntilIdle()
            val result = collectionList[2]

            // Then
            assert(result is UiState.Error)
        }

    @Test
    fun when_started_then_get_most_recent_experiences_is_called() = runTest {
        // Given

        // When
        AroundEgyptViewModel(
            getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
            getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
        )

        // Then
        advanceUntilIdle()
        coVerify { mockGetMostRecentExperiencesUseCase.invoke() }
    }

    @Test
    fun when_update_most_recent_experiences_is_called_then_most_recent_experience_state_is_loading() =
        runTest {
            // Given
            val aroundEgyptViewModel = AroundEgyptViewModel(
                getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
                getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
            )
            val collectionList = mutableListOf<UiState<List<Experience>>>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                aroundEgyptViewModel.mostRecentExperienceUiState.collect {
                    collectionList.add(it)
                }
            }

            // When
            advanceUntilIdle()
            val result = collectionList[1]

            // Then
            assert(result is UiState.Loading)
        }
}