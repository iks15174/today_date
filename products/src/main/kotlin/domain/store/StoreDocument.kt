package com.pjh.domain.store

import com.pjh.domain.LocationDocument
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "store")
class StoreDocument(
    @Field(type = FieldType.Long, index = false)
    val rdbmsId: Long,

    @Field(type = FieldType.Keyword)
    val type: StoreType,

    @Field(type = FieldType.Text)
    val name: String,

    @Field(type = FieldType.Double)
    val rating: Double?,

    @Field(type = FieldType.Long)
    val totalReviewCnt: Long?,

    @Field(type = FieldType.Nested, includeInParent = true)
    val location: LocationDocument,

    @Field(type = FieldType.Nested, includeInParent = true)
    val reviews: List<ReviewDocument> = emptyList(),
) {
    @Id
    val id: String? = null
}