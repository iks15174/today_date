package com.pjh.domain.search

enum class SearchStatus {
    CREATED,
    SCRAPING,
    SCRAPE_COMPLETED,
    SCRAPE_FAILED,
    ALREADY_SCRAPING_BY_OTHER
}