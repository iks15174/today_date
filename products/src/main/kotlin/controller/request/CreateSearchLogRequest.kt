package com.pjh.controller.request

import com.pjh.service.dto.CreateSearchCommand

data class CreateSearchRequest(
    val text: String?,
    val latitude: Double,
    val longitude: Double,
) {
    fun toCommand() = CreateSearchCommand(
        text = text,
        latitude = latitude,
        longitude = longitude,
    )
}