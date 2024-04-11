# Shipping Method Backend Documentation

## Introduction

This documentation provides instructions for setting up, configuring, and running the Shipping Method backend application.

## Prerequisites

Before proceeding with the installation, ensure you have the following prerequisites installed on your system:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [VSCode](https://code.visualstudio.com/) 
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/products/docker-desktop)
- [Postman](https://www.postman.com/downloads/)

## Installation

### 1. Clone Repository

Clone the repository to your local machine using Git:

```bash
git clone https://github.com/Dioddor/uek295-disol-shippingmethod.git
```

### 2. Create Docker Container

Launch Docker and create a docker container with PostgreSQL this command: 

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres
```

### 3. Start Program

Navigate to the project directory and run the Spring Boot application using Gradle:

```bash
gradle bootRun
```

## Testing Endpoints

### Access Endpoints

Open Postman or your web browser and access the following URL: [http://localhost:8080/shippingmethod/](http://localhost:8080/shippingmethod/). From here, you can test various endpoints, including `/shippingmethod` to retrieve all shipping methods or `/shippingmethod/{id}` to retrieve a specific shipping method by its ID.

### CRUD Operations

Use Postman to perform CRUD operations. Choose the desired HTTP method (GET, POST, PUT, DELETE) to interact with endpoints. For instance, you can add new shipping methods, update existing ones, or delete them as well.

## Useful Data

The backend initializes the database with pre-defined values. You can access this data either through the command line interface of your database management system or by referring to the `data.sql` file located in `src/main/resources`. Additionally, two user accounts with different roles and authorities are available for testing purposes:

**Admin**

- Username: admin
- Password: 123

**User**

- Username: Guest
- Password: user1

Ensure to use these credentials for testing authentication and authorization correctly.

## Conclusion

Follow these instructions to successfully set up and run the Shipping Method backend on your local machine.
```

