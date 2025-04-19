package org.example.customer.repository

import org.example.customer.domain.OutboxEvent
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OutboxRepository : JpaRepository<OutboxEvent, UUID>