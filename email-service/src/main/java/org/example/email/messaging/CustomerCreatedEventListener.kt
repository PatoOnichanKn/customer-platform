package org.example.email.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.example.common.event.CustomerCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CustomerCreatedEventListener(private val objectMapper: ObjectMapper) {

    private val logger = LoggerFactory.getLogger(CustomerCreatedEventListener::class.java)

    @KafkaListener(topics = ["customer-created"], groupId = "email-service-group")
    fun listen(record: ConsumerRecord<String, String>) {
        logger.info("📬 Received message: ${record.value()}")
        // TODO: Deserialize JSON → CustomerCreatedEvent and handle email logic
    }

    @KafkaListener(topics = ["customer-created"], groupId = "email-service-group")
    fun listen(payload: String) {
        val event = objectMapper.readValue(payload, CustomerCreatedEvent::class.java)
        logger.info("📬 Received event: $event")
    }
}