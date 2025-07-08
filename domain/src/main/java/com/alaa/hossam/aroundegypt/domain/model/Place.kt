package com.alaa.hossam.aroundegypt.domain.model

data class Place(
    val id: Int = 0,
    val isRecommended: Boolean = false,
    val coverPhoto: String = "",
    val views: Int = 0,
    val title: String = "",
    val likes: Int = 0
)