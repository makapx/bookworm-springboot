# Bookworm - SpringBoot version

A simple SpringBoot project for books.

Based on [Spring Initializr](https://start.spring.io/) template.

## Dependencies

- Java 17
- Maven 3.8.x
- SpringBoot 3.0.2
- MariaDB ( can be changed to MySQL switching package dependency and DB connector )


## Setup

Set proprerly an ```application.properties``` file into ```src/main/resources``` path and create a database for your bookworm instance.

Launch your application:

```bash
mvn spring-boot:run
```

## Docker

Launch your application with Docker:

```bash
docker-compose up -d
```

The web site will be available at http://localhost:8081.

## About

Bookworm is a simple CRUD application for managing books, genres and authors.

Check also [Bookworm - Laravel edition](https://github.com/makapx/bookworm)