package com.pjh.controller

import com.pjh.controller.request.CreateSearchRequest
import com.pjh.service.SearchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/searches")
class SearchController(
    private val searchService: SearchService,
) {

    @PostMapping
    fun search(
        @RequestBody request: CreateSearchRequest
    ) {
        val res = searchService.create(request.toCommand())
        println(res)
    }
}