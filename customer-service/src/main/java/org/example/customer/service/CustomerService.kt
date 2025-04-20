package org.example.customer.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.customer.domain.Customer
import org.example.customer.domain.OutboxEvent
import org.example.customer.messaging.CustomerCreatedEvent
import org.example.customer.repository.CustomerRepository
import org.example.customer.repository.OutboxRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val outboxRepository: OutboxRepository,
    private val objectMapper:ObjectMapper
) {

    @Transactional
    fun createCustomer(firstName: String, lastName: String, email: String): Customer {
        if (customerRepository.findByEmail(email).isPresent) {
            throw IllegalArgumentException("Customer with email $email already exists")
        }

        val customer = Customer(
            firstName = firstName,
            lastName = lastName,
            email = email
        )

        val  savedCustomer = customerRepository.save(customer);
            if(savedCustomer.id ==null){
                throw IllegalStateException("Customer ID should not be null after save")
            }
        val event =
                CustomerCreatedEvent(
                    id = savedCustomer.id,
                    firstName = savedCustomer.firstName,
                    lastName = savedCustomer.lastName,
                    email = savedCustomer.email
                )

        val eventPayLoad = objectMapper.writeValueAsString(event)


        println("🎯 Final payload to store: $eventPayLoad")


        val outboxEvent = OutboxEvent(
            aggregateType = "Customer",
            aggregateId = savedCustomer.id.toString(),
            type = "CustomerCreated",
            payload = eventPayLoad
        )
        println("🎯 before outboxEvent to store: $outboxEvent")

        val savedOutBoxEvent = outboxRepository.save(outboxEvent)
        debugPrintLatestOutboxEvent()
        println("🎯 After outbox store: $savedOutBoxEvent")
        return savedCustomer

    }


    fun debugPrintLatestOutboxEvent() {
        val latest = outboxRepository
            .findAll()
            .sortedByDescending { it.createdAt }
            .firstOrNull()

        if (latest != null) {
            println("🧾 Outbox Event Payload:\n${latest.payload}")
        } else {
            println("🚫 No outbox events found.")
        }
    }

    fun getCustomerById(id: UUID): Customer? =
        customerRepository.findById(id).orElse(null)
}