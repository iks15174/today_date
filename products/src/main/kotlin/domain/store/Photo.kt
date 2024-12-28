package com.pjh.domain.store

import com.pjh.domain.BaseEntity
import jakarta.persistence.*

@Entity
class Photo(
    // photos
    @ManyToOne
    @JoinColumn(name = "store_id")
    val store: Store,

    @Column(length = 512)
    val url: String,

    @Column
    val name: String,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}