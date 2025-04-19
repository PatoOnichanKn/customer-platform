package org.example.customer.event

import java.util.UUID

data class CustomerCreatedEvent(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)