package com.pjh.infra.kafka.schema

import com.pjh.domain.Location
import com.pjh.domain.Search
import java.time.LocalDateTime

data class SearchCreatedEvent(
    val id: Long,
    val text: String?,
    val location: Location,
) {
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun of(search: Search) = SearchCreatedEvent(
            id = search.id,
            text = search.text,
            location = search.location,
        )
    }
}