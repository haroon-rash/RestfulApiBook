
# Book Management API (Spring Boot PRoject)

This project is a professional, modular Book Management System built with Spring Boot.
It focuses on implementing robust backend architecture with clean layering, input validation,
file handling, and RESTful API design. While the current version focuses on managing book and author data, 
the structure is designed for scalability and real-world application integration.

## Objectives

- Implement layered, production-grade backend architecture using Spring Boot
- Develop secure and maintainable REST APIs with input validation and error handling
- Provide clean separation of concerns across controller, service, and repository layers
- Enable file upload capability and prepare for future containerization and service expansion

## Technologies & Patterns Implemented

- Spring Boot – Configuration and modular application structure
- Spring Data JPA – Repository abstraction and in-memory H2 persistence
- DTO Pattern – Separation between entity and data transfer layers
- Jakarta Bean Validation – Request input validation using annotations like 
- Exception Handling – Custom exceptions and centralized error handling with `@ControllerAdvice`
- Service and Repository Layers – Decoupled logic and data access
- File Upload Utility – Encapsulated helper class for multipart file handling
- Manual and Mock Testing – For controller and service layers

## Tech Stack

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 / MySQL Database   
- Lombok  
- Maven  
- RESTful Web Services

## Project Structure

```
src/
├── controller/
│   ├── BookController.java
│   └── FileController.java
│
├── configuration/
│   └── (Application configurations)
│
├── dao/
│   └── customrepository/
│       ├── CustomRepository.java
│       ├── CustomRepositoryImplementation.java
│       └── BooksRepository.java
│
├── entities/
│   ├── Authors.java
│   └── Books.java
│
├── exceptions/
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFound.java
│
├── helper/
│   └── FileUploadHelper.java
│
├── services/
│   └── BookServices.java
```

## Current Functionality

- Full CRUD operations for Book and Author entities
- Custom repository methods for flexible data queries
- File upload functionality using `MultipartFile`
- Unique constraints on entity fields (e.g., title or ISBN)
- Centralized exception handling with meaningful error messages


## Learning Outcomes

- Designed and implemented real-world layered architecture for backend systems
- Built secure REST endpoints using DTOs and validation patterns
- Applied reusable exception-handling mechanisms
- Practiced modular coding practices for scalable backend development

## Next Milestones (Planned)

- Add unit and integration tests using JUnit and Mockito  
- Extend book search with filter and pagination support  
- Dockerize the application for container-based deployment  
- Implement Spring Security with JWT-based authentication  
- Begin integration with other microservices or external systems (e.g., notification service)  
