package com.pjh.infra.kafka.consumer

import com.pjh.infra.kafka.schema.StoreFoundEvent
import org.springframework.stereotype.Component

@Component
class StoreFoundEventLocalConsumer: StoreFoundEventConsumer {
    override fun consume(event: StoreFoundEvent) {
        TODO("Not yet implemented")
    }
}