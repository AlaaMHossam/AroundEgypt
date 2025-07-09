package com.alaa.hossam.aroundegypt.domain.repository

import com.alaa.hossam.aroundegypt.common_utils.DataState
import com.alaa.hossam.aroundegypt.domain.model.Experience

interface ExperienceRepository {
    fun getRecommendedExperiences(): DataState<List<Experience>>
}