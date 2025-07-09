package com.alaa.hossam.aroundegypt.data.data_source

import com.alaa.hossam.aroundegypt.data.model.ExperienceFavoriteDto
import com.alaa.hossam.aroundegypt.data.model.ExperienceResponse
import com.alaa.hossam.aroundegypt.data.model.ExperiencesResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
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

    @GET("/api/v2/experiences/{id}")
    suspend fun getExperience(
        @Path("id") id: String
    ): ExperienceResponse

    @POST("/api/v2/experiences/{id}/like")
    suspend fun favoriteExperience(
        @Path("id") id: String
    ): ExperienceFavoriteDto
}