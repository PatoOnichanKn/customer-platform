package org.example.customer.repository

import org.example.customer.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, UUID> {
    fun findByEmail(email: String): Optional<Customer>
}
