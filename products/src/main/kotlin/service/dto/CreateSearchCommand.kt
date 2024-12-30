package com.pjh.service.dto

import com.pjh.domain.Location
import com.pjh.domain.search.Search

data class CreateSearchCommand(
    val text: String?,
    val latitude: Double,
    val longitude: Double,
) {
    fun toEntity() = Search(
        text = text,
        location = Location.of(
            latitude = latitude,
            longitude = longitude,
        )
    )
}