package org.example.customer.repository

import org.example.customer.domain.OutboxEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OutboxRepository : JpaRepository<OutboxEvent, UUID> {

    fun findTop10ByStatusOrderByCreatedAtAsc(status: String): List<OutboxEvent>
}