package com.pjh.service

import com.pjh.domain.Search
import com.pjh.domain.SearchRepository
import com.pjh.infra.kafka.SearchCreatedEventProducer
import com.pjh.infra.kafka.schema.SearchCreatedEvent
import com.pjh.service.dto.CreateSearchCommand
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchRepository: SearchRepository,
    private val searchCreatedEventProducer: SearchCreatedEventProducer,
) {

    fun create(command: CreateSearchCommand): Search {
        val savedSearch = searchRepository.save(command.toDomain())
        searchCreatedEventProducer.produce(SearchCreatedEvent.of(savedSearch))
        return savedSearch
    }
}