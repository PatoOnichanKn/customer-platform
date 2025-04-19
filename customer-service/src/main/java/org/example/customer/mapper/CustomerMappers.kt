package org.example.customer.mapper

import org.example.customer.domain.Customer
import org.example.customer.dto.CustomerResponseDTO

fun Customer.toResponseDTO() = CustomerResponseDTO(
    id = this.id!!,
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email,
    status = this.status
)