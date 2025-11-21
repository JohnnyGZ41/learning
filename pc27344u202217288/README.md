# Lunaris Platform - RESTful API

## Description
This project implements a RESTful API for Lunaris Tech, specifically designed to manage the registration and information of business Partners. It supports the creation of partners enforcing business rules such as unique representation per company and country, and validates contact information like emails and phone numbers.

The solution is built using Domain-Driven Design (DDD) principles, Layered Architecture, and CQRS pattern with Spring Boot.

## Author
* **Name:** Juan Carlos Pastor Napa
* **Student Code:** u202217288
* **Course:** Desarrollo de Aplicaciones Open Source (1ASI0729)

## Project Specifications
* **Java Version:** 25
* **Framework:** Spring Boot 3.5.6
* **Database:** MySQL
* **Documentation:** OpenAPI / Swagger UI

## How to Run
1. Ensure MySQL is running and the database `lunaris` exists.
2. Run the application using Maven or your IDE.
3. Access Swagger UI at: `http://localhost:8080/swagger-ui/index.html`

## Endpoints
* **POST /api/v1/partners**: Registers a new Partner.
