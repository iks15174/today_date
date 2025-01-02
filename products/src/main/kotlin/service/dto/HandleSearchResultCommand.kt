package com.pjh.service.dto

import com.pjh.domain.search.SearchStatus

data class HandleSearchResultCommand(
    val searchId: Long,
    val status: SearchStatus,
    val stores: List<CreateStoreCommand>
) {
    fun toUpdateSearchStatusCommand() = UpdateSearchStatusCommand(
        searchId = searchId,
        status = status
    )
}