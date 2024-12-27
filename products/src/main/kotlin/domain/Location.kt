package com.pjh.domain

import com.pjh.service.GeoHashService
import jakarta.persistence.Embeddable

@Embeddable
data class Location(
    val latitude: Double,
    val longitude: Double,
    val geoHash: String
) {
    companion object {
        fun of(latitude: Double, longitude: Double) = Location(
            latitude = latitude,
            longitude = longitude,
            geoHash = GeoHashService.toGeoHash(latitude = latitude, longitude = longitude)
        )
    }
}