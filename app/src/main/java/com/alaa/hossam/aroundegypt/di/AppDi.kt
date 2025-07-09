package com.alaa.hossam.aroundegypt.di

import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDi {

    @Singleton
    @Provides
    fun providesGetRecommendedExperiencesUseCase(experienceRepository: ExperienceRepository):
            GetRecommendedExperiencesUseCase =
        GetRecommendedExperiencesUseCase(experienceRepository)
}