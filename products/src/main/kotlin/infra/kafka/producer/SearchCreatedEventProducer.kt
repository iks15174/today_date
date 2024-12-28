package com.pjh.infra.kafka.producer

import com.pjh.infra.kafka.schema.SearchCreatedEvent

interface SearchCreatedEventProducer {
    fun produce(event: SearchCreatedEvent)
}