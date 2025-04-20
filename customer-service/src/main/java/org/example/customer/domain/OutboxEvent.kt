package org.example.customer.domain

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "outbox_events")
data class OutboxEvent(

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val aggregateType: String = "",

    @Column(nullable = false)
    val aggregateId: String = "",

    @Column(nullable = false)
    val type: String = "",

    @Lob
    @Column(nullable = false)
    val payload: String = "",

    @Column(nullable = false)
    var status: String = "PENDING",

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),

    @Column
    var sentAt: Instant? = null
) {
    fun markAsSent() {
        this.status = "SENT"
        this.sentAt = Instant.now()
    }

    fun markAsFailed() {
        this.status = "FAILED"
        this.sentAt = Instant.now()
    }
}
