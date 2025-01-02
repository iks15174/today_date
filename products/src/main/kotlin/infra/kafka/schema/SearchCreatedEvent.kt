package com.pjh.infra.kafka.schema

import com.pjh.domain.Location
import com.pjh.domain.search.Search
import java.time.LocalDateTime

data class SearchCreatedEvent(
    val searchId: Long,
    val text: String?,
    val location: Location,
) {
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun of(search: Search) = SearchCreatedEvent(
            searchId = search.id,
            text = search.text,
            location = search.location,
        )
    }
}