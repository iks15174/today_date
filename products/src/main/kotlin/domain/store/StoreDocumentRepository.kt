package com.pjh.domain.store

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface StoreDocumentRepository : ElasticsearchRepository<StoreDocument, String>