package com.alaa.hossam.aroundegypt.domain.model

data class Experience(
    val id: String = "",
    val isRecommended: Boolean = false,
    val coverPhoto: String = "",
    val views: Int = 0,
    val title: String = "",
    val likes: Int = 0
)