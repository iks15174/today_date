package com.pjh.domain.store

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long> {
    fun findByNameAndLocationGeoHash(name: String, geoHash: String): Store?

    fun findAllByLocationGeoHash(geoHash: String): List<Store>
}