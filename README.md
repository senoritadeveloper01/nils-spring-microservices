# A Sample Spring Boot Microservices Project
This is a sample microservices project developed with Spring Boot and Spring Cloud, using Java version 16.
mikro servis imajı ve spring boot imajı ekleyebilirsin

<img src="https://img.shields.io/badge/Language-Java-orange.svg">

## Submodules:
- Naming Server (implemented with Spring Cloud Eureka)
- API Gateway (implemented with Spring Cloud Gateway)
- Config Server (implemented with Spring Cloud Config and Spring Cloud Bus)

Main Services:
- City Score 
  - It calculates a city score using a parameter from Spring Cloud Config. 
  - Request parameter uses a custom "ValidCityCode" validation.

- Score Segment
  - It calculates a score segment value. 
  - Request parameter uses a custom "ValidIdNumber" validation.

- Score Calculator 
  - It calls CityScore and Score Segment services to calculate a final score. 
  - It uses Spring Cloud Open Feign and Spring Cloud Circuit Breaker. 
  - H2 is used for database implementation. 
  - For API documentation, Springdoc OpenAPI 3 is used.

Spring Cloud Sleuth and Spring Cloud Zipkin are used for distributed tracing.

## Prerequisites and Installation
Docker has to be installed to spin up Kafka and Zipkin.

To start up Kafka and Zipkin, please navigate to "**docker**" folder in your terminal and type:

```
docker-compose -f docker-compose-kafka.yml up
```

## Usage
To test API calls, you can use the collection provided under "**postman**" folder in the root directory (you can ignore gRPC folder).
"API Gateway" folder is used when you are using API Gateway. If you are not, you can call services under the collection's root folder.

Also, you can navigate to the root folder of the project to start up all microservices using Docker images:

```
docker-compose up
```

After the projects' start up is finished,

You can visit [http://localhost:8080/v3/api-docs/](http://localhost:8080/v3/api-docs/) for documentation of Score Calculator API.

To reach Zipkin, you can visit [http://localhost:8761/](http://localhost:8761/).

To reach H2 database UI, please visit [http://localhost:8200/h2-console](http://localhost:8200/h2-console).

**JDBC URL**: jdbc:h2:mem:testdb

**User Name**: sa

**Pasword**: _no password required, leave empty_

## Authors / Contributors / Credits
**Nil Seri**

[Github 1](https://github.com/senoritadeveloper01)

[Github 2](https://github.com/nilseri01)

You can visit [my Medium profile](https://senoritadeveloper.medium.com/) where you can find posts giving detail about important steps for implementing this project.

You can also visit [my Docker Hub](https://hub.docker.com/u/nilseri) for images created for the services in the project.

## Copyright & Licensing Information
This project is licensed under the terms of the MIT license.
