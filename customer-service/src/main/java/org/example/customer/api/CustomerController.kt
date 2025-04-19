package org.example.customer.api

import jakarta.validation.Valid
import org.example.customer.domain.Customer
import org.example.customer.dto.CustomerRequestDTO
import org.example.customer.dto.CustomerResponseDTO
import org.example.customer.mapper.toResponseDTO
import org.example.customer.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/customers")

class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    @PreAuthorize("hasAuthority('customer:write')")
    fun createCustomer(@RequestBody @Valid request: CustomerRequestDTO): ResponseEntity<CustomerResponseDTO> {
        val response = customerService.createCustomer(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email
        )
        return ResponseEntity.created(URI.create("/customers/${response.id}")).body(response.toResponseDTO())
    }
}