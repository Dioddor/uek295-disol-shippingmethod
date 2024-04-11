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

