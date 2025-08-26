# Customer Platform 🚀

![Customer Platform](https://img.shields.io/badge/Customer%20Platform-v1.0.0-blue.svg)

Welcome to the **Customer Platform**! This project is a modular, secure, event-driven microservice built with a variety of modern technologies. It focuses on providing a seamless experience for managing customer interactions and data. 

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Features](#features)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview

The Customer Platform is designed to handle customer data efficiently while ensuring security and scalability. It employs a microservices architecture, which allows for easy integration and maintenance. The platform is built using:

- **Spring Boot**: A framework that simplifies the development of Java applications.
- **Kotlin**: A modern programming language that is concise and expressive.
- **Kafka**: A distributed streaming platform that handles real-time data feeds.
- **Liquibase**: A tool for managing database changes.
- **PostgreSQL**: A powerful, open-source relational database.
- **Keycloak**: An identity and access management tool for securing applications.

For more details, visit our [Releases](https://github.com/PatoOnichanKn/customer-platform/releases) section.

## Technologies Used

The Customer Platform utilizes the following technologies:

- **Domain-Driven Design**: A methodology that focuses on the core domain of the application.
- **Gradle**: A build automation tool used for dependency management.
- **Kafka**: For handling asynchronous messaging.
- **Keycloak**: For OAuth2-based authentication.
- **Kotlin**: As the primary programming language.
- **Liquibase**: For database version control.
- **PostgreSQL**: As the database solution.
- **Spring**: The core framework for building the application.
- **Spring Security OAuth2**: For secure API access.

## Getting Started

To get started with the Customer Platform, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/PatoOnichanKn/customer-platform.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd customer-platform
   ```

3. **Build the project**:

   ```bash
   ./gradlew build
   ```

4. **Run the application**:

   ```bash
   ./gradlew bootRun
   ```

5. **Access the application**: Open your browser and navigate to `http://localhost:8080`.

6. **Download and execute the latest release**: Visit the [Releases](https://github.com/PatoOnichanKn/customer-platform/releases) section to download the latest version.

## Features

The Customer Platform offers several features:

- **Secure Authentication**: Using Keycloak for OAuth2-based security.
- **Event-Driven Architecture**: Leverage Kafka for handling real-time data processing.
- **Modular Design**: Each component can be developed and maintained independently.
- **Database Management**: Liquibase ensures that database changes are tracked and managed.
- **Scalability**: Built to handle increased loads and additional services as needed.

## Usage

After setting up the application, you can interact with it through the REST API. Below are some example endpoints:

- **Get all customers**:

   ```http
   GET /api/customers
   ```

- **Get a customer by ID**:

   ```http
   GET /api/customers/{id}
   ```

- **Create a new customer**:

   ```http
   POST /api/customers
   Content-Type: application/json

   {
       "name": "John Doe",
       "email": "john.doe@example.com"
   }
   ```

- **Update a customer**:

   ```http
   PUT /api/customers/{id}
   Content-Type: application/json

   {
       "name": "Jane Doe",
       "email": "jane.doe@example.com"
   }
   ```

- **Delete a customer**:

   ```http
   DELETE /api/customers/{id}
   ```

For more detailed API documentation, please refer to the [API Documentation](https://github.com/PatoOnichanKn/customer-platform/wiki).

## Contributing

We welcome contributions! If you would like to contribute to the Customer Platform, please follow these steps:

1. **Fork the repository**.
2. **Create a new branch** for your feature or bug fix.
3. **Make your changes** and commit them with clear messages.
4. **Push your changes** to your forked repository.
5. **Submit a pull request**.

Please ensure that your code adheres to the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or feedback, feel free to reach out:

- **Email**: [your-email@example.com](mailto:your-email@example.com)
- **GitHub**: [PatoOnichanKn](https://github.com/PatoOnichanKn)

Thank you for your interest in the Customer Platform! We look forward to your contributions and feedback. 

For further updates and releases, check the [Releases](https://github.com/PatoOnichanKn/customer-platform/releases) section regularly.