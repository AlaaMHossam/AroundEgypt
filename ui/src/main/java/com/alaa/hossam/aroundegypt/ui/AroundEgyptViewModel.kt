package com.alaa.hossam.aroundegypt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.common_utils.UiState
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AroundEgyptViewModel
@Inject constructor(private val getRecommendedExperiencesUseCase: GetRecommendedExperiencesUseCase) :
    ViewModel() {

    private val recommendedExperienceMutableUiState =
        MutableStateFlow<UiState<List<Experience>>>(UiState.Initial)
    val recommendedExperienceUiState = recommendedExperienceMutableUiState.asStateFlow()

    init {
        updateRecommendedExperiences()
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
}
