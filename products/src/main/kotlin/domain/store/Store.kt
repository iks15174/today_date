package com.pjh.domain.store

import com.pjh.domain.BaseEntity
import com.pjh.domain.Location
import jakarta.persistence.*

@Entity
class Store(
    @Column
    @Enumerated(value = EnumType.STRING)
    val internalType: StoreType,

    @Column
    val name: String,

    @Column
    val address: String?,

    @Column
    val linkedUri: String?,

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
}