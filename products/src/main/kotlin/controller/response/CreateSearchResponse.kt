package com.pjh.controller.response

import com.pjh.domain.search.Search
import com.pjh.domain.search.SearchStatus

data class CreateSearchResponse(
    val searchId: Long,
    val status: SearchStatus
) {
    companion object {
        fun of(search: Search) = CreateSearchResponse(
            searchId = search.id,
            status = search.status
        )
    }
}