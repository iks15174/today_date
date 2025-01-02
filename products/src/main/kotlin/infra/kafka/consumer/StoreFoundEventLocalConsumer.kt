package com.pjh.infra.kafka.consumer

import com.pjh.infra.kafka.schema.StoreFoundEvent
import com.pjh.service.SearchResultService
import org.springframework.stereotype.Component

@Component
class StoreFoundEventLocalConsumer(
    private val searchResultService: SearchResultService
) : StoreFoundEventConsumer {

    override fun consume(event: StoreFoundEvent) {
        searchResultService.handle(event.toHandleSearchResultCommand())
    }
}