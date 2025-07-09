package com.alaa.hossam.aroundegypt.data.data_source

import com.alaa.hossam.aroundegypt.data.model.ExperiencesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExperienceRemoteDataSource {

    @GET("/api/v2/experiences")
    suspend fun getRecommendedExperiences(
        @Query("filter[recommended]") recommended: Boolean = true
    ): ExperiencesResponse

    @GET("/api/v2/experiences")
    suspend fun getMostRecentExperiences(): ExperiencesResponse

    @GET("/api/v2/experiences")
    suspend fun search(
        @Query("filter[title]") searchText: String
    ): ExperiencesResponse
}