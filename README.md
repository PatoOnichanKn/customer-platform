# Customer Platform (Kotlin + Spring Boot)

This project is a **modular, secure, event-driven microservice** built with **Spring Boot**, **Kotlin**, **Kafka**, **Liquibase**, **PostgreSQL**, and **Keycloak** for OAuth2-based authentication.

---

## ✅ Functional Summary

### `customer-service`
- `POST /customers`
    - Authenticated via Keycloak (JWT)
    - Accepts a validated customer creation request
    - Saves customer to PostgreSQL
    - Emits `CustomerCreated` event to Outbox table

### `OutboxEvent`
- Stores serialized customer creation events
- To be processed by a Kafka publisher (in a scheduled background job)

### `Validation & Error Handling`
- DTOs are validated with annotations (`@NotBlank`, `@Email`)
- Global exception handler returns structured JSON errors
- `Location: /customers/{id}` header is included in creation responses

---

## 🚀 Getting Started

### Prerequisites
- JDK 17+
- Gradle
- Docker + Docker Compose
- IntelliJ IDEA (recommended)

### 🔧 Setup Steps

```bash
# 1. Clone the repo
$ git clone https://github.com/yourname/customer-platform
$ cd customer-platform

# 2. Start PostgreSQL, Kafka, Zookeeper, Keycloak
$ docker-compose up -d

# 3. Run DB migrations via Liquibase (done automatically)
# OR apply manually by connecting to the DB if needed

# 4. Start the Spring Boot app
$ ./gradlew :customer-service:bootRun
```

---

## 🐳 Docker Compose Services

- PostgreSQL (port 5432)
- Kafka (port 9092) + Zookeeper (2181)
- Keycloak (port 8081)

### 🗝️ Keycloak Setup
1. Visit: `http://localhost:8081`
2. Create Realm: `customer-platform`
3. Create Client: `customer-service`
    - Type: `confidential`
    - Auth flow: `standard` with Direct Access Grants enabled
    - Add `customer:write` role under client
4. Create User:
    - Username: dogan / password: password
    - Assign `customer:write` role
    - Ensure `email_verified = true`

### 🧪 Get Token
```bash
curl -X POST http://localhost:8081/realms/customer-platform/protocol/openid-connect/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "client_id=customer-service" \
  -d "client_secret=your_client_secret" \
  -d "grant_type=password" \
  -d "username=dogan" \
  -d "password=password"
```

---

## 📦 Example API Request

```bash
curl -X POST http://localhost:8080/customers \
  -H "Authorization: Bearer <your_token>" \
  -H "Content-Type: application/json" \
  -d '{
        "firstName": "Ada",
        "lastName": "Lovelace",
        "email": "ada@example.com"
      }'
```

Returns:
```json
HTTP/1.1 201 Created
Location: /customers/{uuid}
{
  "id": "...",
  "firstName": "Ada",
  "lastName": "Lovelace",
  "email": "ada@example.com",
  "status": "PENDING"
}
```

---

## 📋 What’s Done

- ✅ Kotlin multi-module setup (Gradle)
- ✅ PostgreSQL with Liquibase migrations
- ✅ Domain + DTO separation (records)
- ✅ Validations + Global error handler
- ✅ OAuth2 integration with Keycloak
- ✅ Outbox pattern for event storage

---

## ⏭️ Next Steps / TODOs

- [ ] 🔁 Implement Kafka OutboxPublisher (scheduled job)
- [ ] 📬 Create `email-service` Kafka consumer
- [ ] 🧩 Create `crm-service` Kafka consumer
- [ ] 🪦 Add Dead Letter Topic support
- [ ] 📈 Add metrics for retries / failures (Prometheus)
- [ ] 🔐 Secure Swagger UI with OAuth2
- [ ] 🧪 Add integration tests with Testcontainers

---

## 👨‍💻 Author
Doğan Çağlar

