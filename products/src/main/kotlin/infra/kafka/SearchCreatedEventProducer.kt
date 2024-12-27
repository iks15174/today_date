package com.pjh.infra.kafka

import com.pjh.infra.kafka.schema.SearchCreatedEvent

interface SearchCreatedEventProducer {
    fun produce(event: SearchCreatedEvent)
}