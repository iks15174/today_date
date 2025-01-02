package com.pjh.infra.kafka.schema

import com.pjh.domain.search.SearchStatus
import com.pjh.service.dto.CreateStoreCommand
import com.pjh.service.dto.HandleSearchResultCommand

data class StoreFoundEvent(
    val searchId: Long,
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

    fun toHandleSearchResultCommand() = HandleSearchResultCommand(
        searchId = searchId,
        status = SearchStatus.SCRAPE_COMPLETED,
        stores = contents.map {
            CreateStoreCommand(
                type = it.type,
                name = it.name,
                address = it.address,
                linkedUrl = it.linkedUrl,
                rating = it.rating,
                totalReviewCnt = it.totalReviewCnt,
                latitude = it.latitude,
                longitude = it.longitude,
                photos = it.photos.map { photo ->
                    CreateStoreCommand.PhotoDto(
                        url = photo.url,
                        name = photo.name
                    )
                },
                reviews = it.reviews.map { review ->
                    CreateStoreCommand.ReviewDto(
                        content = review.content
                    )
                }
            )
        }
    )
}