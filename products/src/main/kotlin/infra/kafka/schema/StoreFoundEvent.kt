package com.pjh.infra.kafka.schema

data class StoreFoundEvent(
    val contents: List<StoreEventData>
) {
    data class StoreEventData(
        val type: String,

        val name: String,

        val address: String?,

        val linkedUrl: String?,

        val rating: Double?,

        val totalReviewCnt: Long?,

        val latitude: Double,

        val longitude: Double,

        val photos: List<PhotoEventData>,

        val reviews: List<ReviewEventData>,
    ) {
        data class PhotoEventData(
            val url: String,
            val name: String,
        )

        data class ReviewEventData(
            val content: String,
        )
    }
}