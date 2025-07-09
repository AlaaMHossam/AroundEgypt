package com.alaa.hossam.aroundegypt.data.model

import com.alaa.hossam.aroundegypt.domain.model.Experience
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperiencesResponse(
    @SerialName("data")
    val experiences: List<ExperienceDto>
)

@Serializable
data class ExperienceDto(
    @SerialName("id")
    val id: String = "",
    @SerialName("recommended")
    val isRecommended: Int = 0,
    @SerialName("cover_photo")
    val coverPhoto: String = "",
    @SerialName("views_no")
    val views: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("likes_no")
    val likes: Int = 0
)

fun ExperienceDto.toDomain(): Experience {
    return Experience(
        id = id,
        isRecommended = isRecommended == 1,
        coverPhoto = coverPhoto,
        views = views,
        title = title,
        likes = likes
    )
}