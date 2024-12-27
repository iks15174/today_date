package com.pjh.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchRepository : JpaRepository<Search, Long>