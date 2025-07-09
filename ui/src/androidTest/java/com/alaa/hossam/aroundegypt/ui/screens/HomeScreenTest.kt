package com.alaa.hossam.aroundegypt.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.usecase.GetMostRecentExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.SearchUseCase
import com.alaa.hossam.aroundegypt.ui.AroundEgyptViewModel
import com.alaa.hossam.aroundegypt.ui.CLEAR_SEARCH_BUTTON_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.EXPERIENCE_DIALOG_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.EXPERIENCE_LIST_ITEM_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.HOME_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.SEARCH_CONTENT_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.SEARCH_FIELD_TEST_TAG
import com.alaa.hossam.aroundegypt.ui.states.ContentUiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
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
    private val mockSearchUseCase = mockk<SearchUseCase>(relaxed = true)

    private lateinit var spyViewModel: AroundEgyptViewModel

    @Before
    fun setUp() {
        coEvery { mockGetRecommendedExperiencesUseCase.invoke() } returns
                DataState.Success(listOf(Experience("1")))
        coEvery { mockGetMostRecentExperiencesUseCase.invoke() } returns
                DataState.Success(listOf())

        spyViewModel = spyk(
            AroundEgyptViewModel(
                getRecommendedExperiencesUseCase = mockGetRecommendedExperiencesUseCase,
                getMostRecentExperiencesUseCase = mockGetMostRecentExperiencesUseCase,
                searchUseCase = mockSearchUseCase
            )
        )

        composeTestRule.setContent {
            HomeScreen(viewModel = spyViewModel)
        }
    }

    @Test
    fun when_show_search_state_then_search_content_is_displayed() {
        // Given

        // When
        spyViewModel.updateContentUiState(ContentUiState.Search)

        // Then
        composeTestRule.onNodeWithTag(SEARCH_CONTENT_TEST_TAG).assertExists()
    }

    @Test
    fun when_search_ime_action_called_then_search_content_is_displayed() {
        // Given
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performTextInput("Luxor")

        // When
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performImeAction()

        // Then
        composeTestRule.onNodeWithTag(SEARCH_CONTENT_TEST_TAG).assertExists()
    }

    @Test
    fun when_search_ime_action_called_then_search_called_in_view_model() {
        // Given
        val searchText = "Luxor"
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performTextInput(searchText)

        // When
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performImeAction()

        // Then
        coVerify { spyViewModel.updateSearchState(searchText) }
    }

    @Test
    fun when_clear_search_button_clicked_then_search_home_content_is_displayed() {
        // Given
        val searchText = "Luxor"
        coEvery { mockSearchUseCase.invoke(searchText) } returns DataState.Success(listOf())
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performTextInput(searchText)
        composeTestRule.onNodeWithTag(SEARCH_FIELD_TEST_TAG).performImeAction()

        // When
        composeTestRule.onNodeWithTag(CLEAR_SEARCH_BUTTON_TEST_TAG).performClick()

        // Then
        composeTestRule.onNodeWithTag(HOME_CONTENT_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun when_experience_clicked_then_experience_details_is_displayed() {
        // Given

        // When
        composeTestRule.onNodeWithTag(EXPERIENCE_LIST_ITEM_TEST_TAG).performClick()

        // Then
        composeTestRule.onNodeWithTag(EXPERIENCE_DIALOG_TEST_TAG).assertIsDisplayed()
    }
}