# orderfy

[![Build Status](https://travis-ci.org/brunosimioni/orderfy.svg?branch=master)](https://travis-ci.org/brunosimioni/orderfy)
[![Coverage Status](https://coveralls.io/repos/github/brunosimioni/orderfy/badge.svg)](https://coveralls.io/github/brunosimioni/orderfy)

# Proof-of-technology

A simple proof-of-technology for an ecommerce platform. This is a currently work-in-progress, composed by following techs:

### Foundation && CI
- Spring Boot 1.4.0 testing [done]
- Travis CI continuous integration [done]
- Coveralls for static analysis and code lint [partially done]
- Spring Cloud Netflix OSS
   - Eureka: client-side service discovery [done] 
   - Hystrix: circuit breaker implementation [done]
   - Turbine: circuit breaker monitoring aggregation [done]
   - Feign: Rest serivce consumption [done]
   - Zuul: API gateway [done]
   - Configuration: externalized and centralized configuration by using git [not started yet]
   - Stream: amqp messaging streaming [done]
- Clean Architecture [done]
- Google Protobuf Protocol [done]
- Swagger API documentation with Spring Fox

### Testing
- Gatling [done]

### Data Mining
- Apache Kafka [not started yet]
- Apache Spark [not started yet]

### Data Storage and processing
- Apache Cassandra [not started yet]
- RabbitMQ []
- Redis [partially done]
- MongoDB [partially done]
- Docker Compose for local deployment with wait-for-it dependencies [done]
- Kubernetes for cloud-native deployment [partially done]

## Basic project organization
- `backend-modules`: Backend modules for orderfy platform
- `frontend-modules`: Frontend modules for orderfy platform
- `tpsource-modules`: 3rd-party modules as source of external integrations
- `insights-modules`: Insights and analytics modules for orderfy platform
- `quality-modules`: Following Testing microservices by Martin Fowler
- `toolbox-modules`: Toolbox and common modules to keep orderfy up&running
- `traffic-generator`: A simple random traffic generator for orderfy platform
- `scripts`: Build and run tools

# Application Modules [wip]

- `backend-modules/catalog-service`: a wrapper service to [Akeneo PIM](https://www.akeneo.com/)
- `backend-modules/checkout-service`: a simple cart&checkout service by consuming discovery services, powered by hystrix circuit-breakers, monitoring and API documentation
- `backend-modules/customers-service`: a customer-oriented MDM
- `backend-modules/search-service`: a thin Elastic-search wrapper, enabled by [Protobuf](https://github.com/google/protobuf) protocol
- `toolbox-modules/discovery-service`: Netflix OSS Eureka service discovery server
- `toolbox-modules/apigateway-service`: Netflix OSS Zuul API Gateway
- `toolbox-modules/circuitmonitor-service`: Netflix OSS Turbine (Hystrix aggregator monitor)
- `toolbox-modules/circuitmonitor-service`: Netflix OSS Turbine (Hystrix aggregator monitor)
- `traffic-generator`: Gatling Framework (Akka / Play / Scala) powered stress tests

## Run it
1. mvn clean install
2. docker-compose up

## Inspect it
- Spring Cloud Zuul (API Gateway): `http://localhost:8000/`
- Spring Cloud Zuul Routes (API Gateway): `http://localhost:8000/routes`
- Spring Cloud Eureka: `http://localhost:8001/`
- Spring Cloud Turbine: `http://localhost:8002/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8903%2Fturbine.stream`
- RabbitMQ exchanges and queues: `http://localhost:15672/` [guest:guest]
- Orderfy Backend Catalog Service: `http://localhost:9000/`
- Orderfy Backend Customers Service: `http://localhost:9001/`
- Orderfy Backend Checkout Service: `http://localhost:9002/`
- Orderfy Backend Checkout Service Swagger 2.0 docs: `http://localhost:9002/v2/api-docs`
- Orderfy Backend Checkout Service Swagger UI: `http://localhost:9002/swagger-ui.html`
- Orderfy Backend Search Service: `http://localhost:9003/`