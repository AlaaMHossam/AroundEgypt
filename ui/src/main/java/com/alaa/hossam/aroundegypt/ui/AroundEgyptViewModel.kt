package com.alaa.hossam.aroundegypt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.usecase.FavoriteExperienceUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetExperienceUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetMostRecentExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.SearchUseCase
import com.alaa.hossam.aroundegypt.ui.states.ContentUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AroundEgyptViewModel
@Inject constructor(
    private val getRecommendedExperiencesUseCase: GetRecommendedExperiencesUseCase,
    private val getMostRecentExperiencesUseCase: GetMostRecentExperiencesUseCase,
    private val searchUseCase: SearchUseCase,
    private val getExperienceUseCase: GetExperienceUseCase,
    private val favoriteExperienceUseCase: FavoriteExperienceUseCase
) : ViewModel() {

    private val recommendedExperienceMutableUiState =
        MutableStateFlow<UiState<List<Experience>>>(UiState.Initial)
    val recommendedExperienceUiState = recommendedExperienceMutableUiState.asStateFlow()

    private val mostRecentExperienceMutableUiState =
        MutableStateFlow<UiState<List<Experience>>>(UiState.Initial)
    val mostRecentExperienceUiState = mostRecentExperienceMutableUiState.asStateFlow()

    private val contentMutableUiState = MutableStateFlow<ContentUiState>(ContentUiState.Home)
    val contentUiState = contentMutableUiState.asStateFlow()

    private val searchMutableState = MutableStateFlow<UiState<List<Experience>>>(UiState.Initial)
    val searchState = searchMutableState.asStateFlow()

    private val experienceMutableState = MutableStateFlow<UiState<Experience>>(UiState.Initial)
    val experienceState = experienceMutableState.asStateFlow()

    private val favoritesMutableState = MutableStateFlow(0)
    val favoritesState = favoritesMutableState.asStateFlow()

    init {
        updateRecommendedExperiences()
        updateMostRecentExperiences()
    }

    private fun updateRecommendedExperiences() {
        viewModelScope.launch {
            recommendedExperienceMutableUiState.update { UiState.Loading }
            val result = getRecommendedExperiencesUseCase.invoke()
            when (result) {
                is DataState.Success ->
                    recommendedExperienceMutableUiState.update { UiState.Success(result.data) }

                is DataState.Error ->
                    recommendedExperienceMutableUiState.update { UiState.Error(result.message) }
            }
        }
    }

    private fun updateMostRecentExperiences() {
        viewModelScope.launch {
            mostRecentExperienceMutableUiState.update { UiState.Loading }
            val result = getMostRecentExperiencesUseCase.invoke()
            when (result) {
                is DataState.Success ->
                    mostRecentExperienceMutableUiState.update { UiState.Success(result.data) }

                is DataState.Error ->
                    mostRecentExperienceMutableUiState.update { UiState.Error(result.message) }
            }
        }
    }

    fun updateContentUiState(contentUiState: ContentUiState) {
        contentMutableUiState.update { contentUiState }
    }

    fun updateSearchState(searchText: String) {
        viewModelScope.launch {
            searchMutableState.update { UiState.Loading }
            val result = searchUseCase.invoke(searchText)
            when (result) {
                is DataState.Success ->
                    searchMutableState.update { UiState.Success(result.data) }

                is DataState.Error ->
                    searchMutableState.update { UiState.Error(result.message) }
            }
        }
    }

    fun updateExperienceState(id: String) {
        viewModelScope.launch {
            experienceMutableState.update { UiState.Loading }
            val result = getExperienceUseCase.invoke(id)
            when (result) {
                is DataState.Success ->
                    experienceMutableState.update { UiState.Success(result.data) }

                is DataState.Error ->
                    experienceMutableState.update { UiState.Error(result.message) }
            }
        }
    }

    fun addExperienceToFavorites(id: String) {
        viewModelScope.launch {
            val result = favoriteExperienceUseCase.invoke(id)
            when (result) {
                is DataState.Success ->
                    favoritesMutableState.update {result.data}

                is DataState.Error ->
                    favoritesMutableState.update { 0 }
            }
        }
    }
}
