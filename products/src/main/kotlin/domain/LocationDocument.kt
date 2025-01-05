package com.pjh.domain

import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

data class LocationDocument(
    @Field(type = FieldType.Double)
    val latitude: Double,

    @Field(type = FieldType.Double)
    val longitude: Double,

    @Field(type = FieldType.Text)
    val geoHash: String
)