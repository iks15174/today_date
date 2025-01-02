package com.pjh.service

import com.pjh.domain.store.Store
import com.pjh.domain.store.StoreRepository
import com.pjh.service.dto.CreateStoreCommand
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val storeRepository: StoreRepository,
) {
    fun createIfNotExists(command: CreateStoreCommand): Store {
        val entity = storeRepository.findByNameAndLocationGeoHash(
            name = command.name,
            geoHash = command.geoHash
        )
        return if (entity == null) {
            storeRepository.save(command.toEntity())
        } else {
            entity
        }
    }
}