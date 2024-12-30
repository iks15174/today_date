package com.pjh.domain.store

import com.pjh.domain.BaseEntity
import com.pjh.domain.Location
import jakarta.persistence.*

@Entity
class Store(
    @Column
    @Enumerated(value = EnumType.STRING)
    val type: StoreType,

    @Column
    val name: String,

    @Column
    val address: String?,

    @Column
    val linkedUrl: String?,

    @Column
    val rating: Double?,

    @Column
    val totalReviewCnt: Long?,

    @Column
    val location: Location,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToMany(mappedBy = "place", cascade = [CascadeType.ALL])
    private val _photos: MutableList<Photo> = mutableListOf()

    val photos: List<Photo>
        get() = _photos.toList()

    @OneToMany(mappedBy = "place", cascade = [CascadeType.ALL])
    private val _reviews: MutableList<Review> = mutableListOf()

    val reviews: List<Review>
        get() = _reviews.toList()

    fun addReviews(reviews: List<Review>): Store {
        this._reviews.addAll(reviews)
        return this
    }

    fun addPhotos(photos: List<Photo>): Store {
        this._photos.addAll(photos)
        return this
    }
}