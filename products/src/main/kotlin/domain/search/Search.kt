package com.pjh.domain.search

import com.pjh.domain.BaseEntity
import com.pjh.domain.Location
import jakarta.persistence.*

@Entity
class Search(
    @Column
    val text: String?,

    @Embedded
    val location: Location
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column
    var status: SearchStatus = SearchStatus.CREATED
        private set

    @ManyToOne
    @JoinColumn(name = "parent_search_id")
    var parentSearch: Search? = null
        private set
}