package com.pjh.infra.kafka

import com.pjh.infra.kafka.schema.SearchCreatedEvent
import org.springframework.stereotype.Component

@Component
class SearchCreatedEventLocalProducer : SearchCreatedEventProducer {
    override fun produce(event: SearchCreatedEvent) {
        println("hi")
    }
}