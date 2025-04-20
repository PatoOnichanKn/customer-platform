// common/src/main/kotlin/org/example/common/dto/CustomerCreatedEvent.kt
package org.example.customer.messaging

import java.util.*

data class CustomerCreatedEvent(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)