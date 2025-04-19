package org.example.customer.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CustomerRequestDTO(
    @field:NotBlank(message = "First name is required")
    val firstName: String,

    @field:NotBlank(message = "Last name is required")
    val lastName: String,

    @field:Email(message = "Invalid email address")
    @field:NotBlank(message = "Email is required")
    val email: String
)