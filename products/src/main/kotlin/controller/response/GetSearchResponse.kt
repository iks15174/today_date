package com.pjh.controller.response

import com.pjh.domain.Search
import com.pjh.domain.SearchStatus

data class GetSearchResponse(
    val searchId: Long,
    val status: SearchStatus,
) {
    companion object {
        fun of(search: Search) = GetSearchResponse(
            searchId = search.id,
            status = search.status
        )
    }
}