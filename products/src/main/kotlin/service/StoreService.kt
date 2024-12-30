package com.pjh.service

import com.pjh.domain.store.Store
import com.pjh.domain.store.StoreRepository
import com.pjh.service.dto.CreateStoreCommand
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val storeRepository: StoreRepository,
) {
    fun create(command: CreateStoreCommand): Store {
        return storeRepository.save(command.toEntity())
    }
}