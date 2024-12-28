package com.pjh.infra.kafka.schema

data class StoreFoundEvent(
    val contents: List<StoreEventSchema>
) {
    data class StoreEventSchema(
        val type: String,

        val name: String,

        val address: String?,

        val linkedUrl: String?,

        val rating: Double?,

        val totalReviewCnt: Long?,

        val latitude: Double,

        val longitude: Double,

        val photos: List<PhotoEventSchema>,

        val reviews: List<ReviewEventSchema>,
    ) {
        data class PhotoEventSchema(
            val url: String,
            val name: String,
        )

        data class ReviewEventSchema(
            val content: String,
        )
    }
}