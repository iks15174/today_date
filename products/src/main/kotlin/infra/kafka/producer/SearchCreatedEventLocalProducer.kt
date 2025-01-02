package com.pjh.infra.kafka.producer

import com.pjh.infra.kafka.consumer.StoreFoundEventConsumer
import com.pjh.infra.kafka.schema.SearchCreatedEvent
import com.pjh.infra.kafka.schema.StoreFoundEvent
import com.pjh.infra.kafka.schema.StoreFoundEvent.StoreEventData
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
class SearchCreatedEventLocalProducer(
    @Lazy private val storeFoundEventConsumer: StoreFoundEventConsumer
) : SearchCreatedEventProducer {
    override fun produce(event: SearchCreatedEvent) {
        println("produce search created event (ID: ${event.searchId})")
        storeFoundEventConsumer.consume(createStoreFoundEvent(searchId = event.searchId, cnt = 10))
    }

    private fun createStoreFoundEvent(searchId: Long, cnt: Int): StoreFoundEvent {
        val contents = (0 until cnt).map {
            StoreEventData(
                type = "RESTAURANTS",
                name = "테스트 식당 $it",
                address = "강북구",
                linkedUrl = null,
                rating = 4.2,
                totalReviewCnt = 10,
                latitude = 37.618149,
                longitude = 127.026911,
                photos = emptyList(),
                reviews = emptyList()
            )
        }
        return StoreFoundEvent(searchId = searchId, contents = contents)
    }
}