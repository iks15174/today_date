package com.pjh.domain.store

import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

data class ReviewDocument(
    @Field(type = FieldType.Text)
    val comment: String
)