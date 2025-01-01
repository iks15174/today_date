package com.pjh.service.dto

import com.pjh.domain.search.SearchStatus

data class UpdateSearchStatusCommand(
    val searchId: Long,
    val status: SearchStatus,
)