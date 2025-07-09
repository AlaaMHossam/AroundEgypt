package com.alaa.hossam.aroundegypt.data.model

import kotlinx.serialization.SerialName

data class ExperienceDto(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("is_recommended")
    val isRecommended: Boolean = false,
    @SerialName("cover_photo")
    val coverPhoto: String = "",
    @SerialName("views")
    val views: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("likes")
    val likes: Int = 0
)