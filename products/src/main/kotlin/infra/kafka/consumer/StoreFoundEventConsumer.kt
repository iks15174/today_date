package com.pjh.infra.kafka.consumer

import com.pjh.infra.kafka.schema.StoreFoundEvent

interface StoreFoundEventConsumer {
    fun consume(event: StoreFoundEvent)
}