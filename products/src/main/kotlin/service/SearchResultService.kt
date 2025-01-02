package com.pjh.service

import com.pjh.service.dto.HandleSearchResultCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchResultService(
    private val storeService: StoreService,
    private val searchService: SearchService,
) {

    @Transactional
    fun handle(command: HandleSearchResultCommand) {
        searchService.updateStatus(command.toUpdateSearchStatusCommand())
        command.stores.forEach {
            storeService.createIfNotExists(it)
        }
    }
}