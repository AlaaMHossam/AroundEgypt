package com.alaa.hossam.aroundegypt.data.di

import com.alaa.hossam.aroundegypt.data.BuildConfig
import com.alaa.hossam.aroundegypt.data.data_source.ExperienceRemoteDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataDi {

    val json = Json { ignoreUnknownKeys = true }

    val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(false)
        .followRedirects(true)
        .followSslRedirects(true)
        .cache(null)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Singleton
    @Provides
    internal fun provideExperienceRemoteDataSource(): ExperienceRemoteDataSource =
        retrofit.create(ExperienceRemoteDataSource::class.java)

}