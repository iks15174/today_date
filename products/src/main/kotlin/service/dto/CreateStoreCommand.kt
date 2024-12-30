package com.pjh.service.dto

import com.pjh.domain.Location
import com.pjh.domain.store.Photo
import com.pjh.domain.store.Review
import com.pjh.domain.store.Store
import com.pjh.domain.store.StoreType

data class CreateStoreCommand(
    val type: String,

    val name: String,

    val address: String?,

    val linkedUrl: String?,

    val rating: Double?,

    val totalReviewCnt: Long?,

    val latitude: Double,

    val longitude: Double,

    val photos: List<PhotoDto>,

    val reviews: List<ReviewDto>,
) {
    data class PhotoDto(
        val url: String,
        val name: String,
    )

    data class ReviewDto(
        val content: String,
    )

    fun toEntity(): Store {
        val store = Store(
            type = StoreType.valueOf(type),
            name = name,
            address = address,
            linkedUrl = linkedUrl,
            rating = rating,
            totalReviewCnt = totalReviewCnt,
            location = Location.of(latitude = latitude, longitude = longitude),
        )

        val reviews = reviews.map { Review(store = store, content = it.content) }
        val photos = photos.map { Photo(store = store, url = it.url, name = it.name) }

        return store.addPhotos(photos).addReviews(reviews)
    }
}