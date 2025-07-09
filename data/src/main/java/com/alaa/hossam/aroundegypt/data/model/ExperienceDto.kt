package com.alaa.hossam.aroundegypt.data.model

import com.alaa.hossam.aroundegypt.domain.model.Experience
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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

fun ExperienceDto.toDomain(): Experience {
    return Experience(
        id = id,
        isRecommended = isRecommended,
        coverPhoto = coverPhoto,
        views = views,
        title = title,
        likes = likes
    )
}