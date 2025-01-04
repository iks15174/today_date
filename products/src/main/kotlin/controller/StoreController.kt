package com.pjh.controller

import com.pjh.domain.store.Store
import com.pjh.service.StoreService
import com.pjh.service.dto.GetStoreCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/stores")
class StoreController(
    private val storeService: StoreService,
) {
    @GetMapping
    fun getStores(
        @RequestParam longitude: Double,
        @RequestParam latitude: Double
    ): List<Store> {
        return storeService.getBy(
            GetStoreCommand(
                latitude = latitude,
                longitude = longitude
            )
        )
    }
}