package com.alaa.hossam.aroundegypt.data.di

import android.content.Context
import androidx.room.Room
import com.alaa.hossam.aroundegypt.data.BuildConfig
import com.alaa.hossam.aroundegypt.data.data_source.AppDB
import com.alaa.hossam.aroundegypt.data.data_source.ExperienceDao
import com.alaa.hossam.aroundegypt.data.data_source.ExperienceRemoteDataSource
import com.alaa.hossam.aroundegypt.data.repository.ExperienceRepositoryImpl
import com.alaa.hossam.aroundegypt.domain.repository.ExperienceRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataDi {
    val cacheSize = 50L * 1024 * 1024 // 50 MB

    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache {
        return Cache(File(context.cacheDir, "http_cache"), cacheSize)
    }

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            //.retryOnConnectionFailure(false)
            .followRedirects(true)
            .followSslRedirects(true)
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .header("Cache-Control", "public, max-age=60") // force cache for 60s
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
    }

    @Singleton
    @Provides
    internal fun providesExperienceRemoteDataSource(retrofit: Retrofit): ExperienceRemoteDataSource =
        retrofit.create(ExperienceRemoteDataSource::class.java)

    @Provides
    fun providesRoom(@ApplicationContext context: Context): AppDB =
        Room.databaseBuilder(context, AppDB::class.java, "AppDB.db")
            .build()

    @Provides
    fun providesExperienceDao(appDB: AppDB): ExperienceDao = appDB.experienceDao()

    @Singleton
    @Provides
    fun providesExperienceRepository(
        experienceRemoteDataSource: ExperienceRemoteDataSource, experienceDao: ExperienceDao
    ): ExperienceRepository = ExperienceRepositoryImpl(experienceRemoteDataSource, experienceDao)
}