package org.example.email

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka // 👈 Add this!

@SpringBootApplication
@EnableKafka // 👈 This enables @KafkaListener
class EmailServiceApplication

fun main(args: Array<String>) {
    runApplication<EmailServiceApplication>(*args)
}