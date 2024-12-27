package com.pjh.service

import com.pjh.domain.Search
import com.pjh.domain.SearchRepository
import com.pjh.infra.kafka.SearchCreatedEventProducer
import com.pjh.infra.kafka.schema.SearchCreatedEvent
import com.pjh.service.dto.CreateSearchCommand
import org.springframework.data.repository.findByIdOrNull
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

    fun get(searchId: Long): Search {
        return searchRepository.findByIdOrNull(searchId)
            ?: throw IllegalArgumentException("존재하지 않는 아이디 입니다 (search id: $searchId)")
    }
}