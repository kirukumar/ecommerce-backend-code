# E-Commerce Backend Application

This is a backend application for an e-commerce platform, developed using **Java Spring Boot**. It provides a robust set of RESTful APIs to manage user authentication, shopping cart operations, and product-specific logic (Titan).

## Features

- **User Authentication**: Handled through the `LoginController`.
- **Cart Management**: Add, update, or remove items using the `CartController`.
- **Titan Module**: Product-specific logic is encapsulated within the `TitanController`.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- H2 / MySQL (configurable)
- Maven

## Getting Started

### Prerequisites

- Java
- Maven
- MySQL or H2 Database

### Build and Run

```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
