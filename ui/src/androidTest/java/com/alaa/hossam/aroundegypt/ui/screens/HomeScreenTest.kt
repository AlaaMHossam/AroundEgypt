package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.usecase.GetMostRecentExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import com.alaa.hossam.aroundegypt.ui.AroundEgyptViewModel
import com.alaa.hossam.aroundegypt.ui.SEARCH_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.states.ContentUiState
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockGetRecommendedExperiencesUseCase =
        mockk<GetRecommendedExperiencesUseCase>(relaxed = true)
    private val mockGetMostRecentExperiencesUseCase =
        mockk<GetMostRecentExperiencesUseCase>(relaxed = true)

    private lateinit var viewModel: AroundEgyptViewModel

    @Before
    fun setUp() {
        coEvery { mockGetRecommendedExperiencesUseCase.invoke() } returns DataState.Success(listOf())
        coEvery { mockGetMostRecentExperiencesUseCase.invoke() } returns DataState.Success(listOf())

        viewModel = AroundEgyptViewModel(
            getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
            getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase
        )

        composeTestRule.setContent {
            HomeScreen(viewModel = viewModel)
        }
    }

    @Test
    fun when_show_search_state_then_search_content_is_displayed() {
        // Given

        // When
        viewModel.updateContentUiState(ContentUiState.Search)

        // Then
        composeTestRule.onNodeWithTag(SEARCH_CONTENT_TEST_TAG).assertExists()
    }
}