package com.alaa.hossam.aroundegypt.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alaa.hossam.aroundegypt.data.model.ExperienceEntity

@Database(
    entities = [ExperienceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDB : RoomDatabase() {
    abstract fun experienceDao(): ExperienceDao
}