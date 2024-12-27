package com.pjh.service

import ch.hsr.geohash.GeoHash

object GeoHashService {

    fun toGeoHash(latitude: Double, longitude: Double, precision: Int = 8): String =
        GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude, precision)

    fun decodeGeoHash(geoHash: String): Pair<Double, Double> {
        val point = GeoHash.fromGeohashString(geoHash).boundingBox.center
        return Pair(point.latitude, point.longitude)
    }
}