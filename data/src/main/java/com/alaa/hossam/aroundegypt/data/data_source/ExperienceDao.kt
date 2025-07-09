package com.alaa.hossam.aroundegypt.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alaa.hossam.aroundegypt.data.model.ExperienceEntity

@Dao
interface ExperienceDao {
    @Query("SELECT * FROM experiences WHERE fromIsRecommendedList = 1")
    suspend fun getRecommendedExperiences(): List<ExperienceEntity>

    @Query("SELECT * FROM experiences WHERE fromIsMostRecentList = 1")
    suspend fun getMostRecentExperiences(): List<ExperienceEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveExperiences(experiences: List<ExperienceEntity>)
}