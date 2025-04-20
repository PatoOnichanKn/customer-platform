package org.example.customer.messaging

import org.apache.kafka.clients.producer.ProducerRecord
import org.example.common.constants.KafkaTopics
import org.example.customer.repository.OutboxRepository
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class KafkaOutboxPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val outboxRepository: OutboxRepository
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedDelay = 5000)
    @Transactional
    fun publishPendingEvents() {
        logger.info("📣 Checking for pending outbox events...")

        val events = outboxRepository.findTop10ByStatusOrderByCreatedAtAsc("PENDING")

        events.forEach { event ->
            try {
                val record = ProducerRecord(
                    KafkaTopics.CUSTOMER_CREATED,
                    event.aggregateId,
                    event.payload
                )

                kafkaTemplate.send(record).whenComplete { _, ex ->
                    if (ex == null) {
                        logger.info("✅ Sent event ${'$'}{event.id}")
                        event.markAsSent()
                        outboxRepository.save(event)
                    } else {
                        logger.error("❌ Failed to send event ${'$'}{event.id}: ${'$'}{ex.message}", ex)
                        event.markAsFailed()
                        outboxRepository.save(event)
                    }
                }
            } catch (ex: Exception) {
                logger.error("❌ Unexpected error publishing event ${'$'}{event.id}", ex)
                event.status = "FAILED"
                outboxRepository.save(event)
            }
        }
    }
}
