[![Build Status](https://travis-ci.com/niomwungeri-fabrice/taxi24.svg?branch=master)](https://travis-ci.com/niomwungeri-fabrice/taxi24)
[![Maintainability](https://api.codeclimate.com/v1/badges/ed8986a3c3701bd22341/maintainability)](https://codeclimate.com/github/niomwungeri-fabrice/taxi24/maintainability)

# Taxi24

Taxi24 is a new startup based in Kigali. They would like to disrupt the taxi industry in Rwanda by providing a white-label solution to the existing taxi companies and hotels. Practically, they will build a set of APIs that other companies can use to manage their fleet of drivers and allocate drivers to passengers. They would like your help building these APIs

## Before started

- `N.B: Install mvn`
- `install JDK8`

## After cloning repository

- `Create a .env file and copy/paste the environment variables from the .env_example file that's already existent in the root project directory.`
- `Update application.properties file with local database credentials`

## Getting started

```sh
$ git clone https://github.com/niomwungeri-fabrice/taxi24.git
$ cd taxi24
$ mvn spring-boot:run
```

## Run tests

```sh
$ mvn clean test coveralls:report
```
## EndPoints

| EndPoint                     | Functionality             |
| ---------------------------- | ------------------------- |
| `GET /drivers`               | Fetch all drivers         |
| `POST /drivers`              | Create a driver           |
| `GET /driver/{driverId}`     | Fetch one driver using id |
| `PUT /drivers/{driverId}`    | Update a driver           |
| `GET /drivers/{unitTest}/available` | Get available drivers within specified ranges range |
| `GET /riders`               | Fetch all riders         |
| `POST /riders`              | Create a rider           |
| `GET /riders/{riderId}`     | Fetch one rider using id |
| `PUT /riders/{riderId}`    | Update a rider           |
| `DELETE /riders/{riderId}` | Delete a rider           |
| `POST /trip/new`|create a new trip|
| `GET /trip/{tripId}`|Fetch one trip|
| `GET /trip/active`|Get a list of all active Trips|


## Project built with:

- `JavaEE 8`
- `Spring Boot 2`
- `Hibernate`
- `PostgreSql`

## Reference:
- `Bank of kigali`
