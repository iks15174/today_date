package com.pjh.controller

import com.pjh.controller.request.CreateSearchRequest
import com.pjh.controller.response.CreateSearchResponse
import com.pjh.controller.response.GetSearchResponse
import com.pjh.service.SearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/searches")
class SearchController(
    private val searchService: SearchService,
) {

    @PostMapping
    fun search(
        @RequestBody request: CreateSearchRequest
    ): ResponseEntity<CreateSearchResponse> {
        val search = searchService.create(request.toCommand())
        return ResponseEntity.ok(CreateSearchResponse.of(search))
    }

    @GetMapping("/{searchId}")
    fun getSearch(
        @PathVariable("searchId") searchId: Long
    ): ResponseEntity<GetSearchResponse> {
        val search = searchService.get(searchId)
        return ResponseEntity.ok(GetSearchResponse.of(search))
    }
}