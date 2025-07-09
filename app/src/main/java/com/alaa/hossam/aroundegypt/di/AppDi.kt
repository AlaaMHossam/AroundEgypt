package com.alaa.hossam.aroundegypt.di

import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import com.alaa.hossam.aroundegypt.domain.usecase.GetExperienceUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetMostRecentExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.GetRecommendedExperiencesUseCase
import com.alaa.hossam.aroundegypt.domain.usecase.SearchUseCase
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

    @Singleton
    @Provides
    fun providesGetMostRecentExperiencesUseCase(experienceRepository: ExperienceRepository):
            GetMostRecentExperiencesUseCase =
        GetMostRecentExperiencesUseCase(experienceRepository)

    @Singleton
    @Provides
    fun providesSearchUseCase(experienceRepository: ExperienceRepository):
            SearchUseCase = SearchUseCase(experienceRepository)

    @Singleton
    @Provides
    fun providesGetExperienceUseCase(experienceRepository: ExperienceRepository):
            GetExperienceUseCase = GetExperienceUseCase(experienceRepository)

}