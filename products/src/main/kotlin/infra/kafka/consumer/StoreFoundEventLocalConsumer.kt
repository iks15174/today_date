package com.pjh.infra.kafka.consumer

import com.pjh.infra.kafka.schema.StoreFoundEvent
import org.springframework.stereotype.Component

@Component
class StoreFoundEventLocalConsumer: StoreFoundEventConsumer {

    override fun consume(event: StoreFoundEvent) {
        /*
        1. 검색 상태 수정
        2. store 저장
        3. es 에 store 저장 -> 별도의 리스너에서
         */
    }
}