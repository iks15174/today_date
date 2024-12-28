package com.pjh.domain.store

import com.pjh.domain.BaseEntity
import jakarta.persistence.*

@Entity
class Review(
    @ManyToOne
    @JoinColumn(name = "store_id")
    val store: Store,

    @Column(columnDefinition = "TEXT")
    val content: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}