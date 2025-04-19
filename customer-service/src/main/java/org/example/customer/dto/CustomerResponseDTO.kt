package org.example.customer.dto

import java.util.*

data class CustomerResponseDTO(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val status: String
)