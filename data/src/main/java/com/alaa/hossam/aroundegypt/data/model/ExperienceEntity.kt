package com.alaa.hossam.aroundegypt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experiences")
data class ExperienceEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val isRecommended: Boolean = false,
    val coverPhoto: String = "",
    val views: Int = 0,
    val title: String = "",
    val city: String = "",
    val description: String = "",
    val likes: Int = 0,
    val fromIsRecommendedList: Int = 0,
    val fromIsMostRecentList: Int = 0
)