package org.example.customer.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "customers")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val status: String = "PENDING"
)
