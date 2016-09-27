# orderfy

[![Build Status](https://travis-ci.org/brunosimioni/orderfy.svg?branch=master)](https://travis-ci.org/brunosimioni/orderfy)
[![Coverage Status](https://coveralls.io/repos/github/brunosimioni/orderfy/badge.svg)](https://coveralls.io/github/brunosimioni/orderfy)

# Proof-of-technology

A simple proof-of-technology for an ecommerce platform. This is a currently work-in-progress, composed by following techs:

### Foundation && CI
- Spring Boot 1.4.0 testing [done]
- Travis CI continuous integration [done]
- Coveralls for static analysis and code lint [partially done]
- Spring Cloud Netflix OSS (Eureka, Hystrix, Feign, Zuul, etc) [partially done]
- Clean Architecture [partially-done]
- Google Protobuf Protocol [not started yet]

### Testing
- Gatling [not started yet]

### Data Mining
- Apache Kafka [not started yet]
- Apache Spark [not started yet]

### Data Storage
- Apache Cassandra [not started yet]
- RabbitMQ [partially done]
- Redis [partially done]
- MongoDB [partially done]
- Docker Compose for local deployment with wait-for-it dependencies [done]
- Kubernetes for cloud-native deployment [partially done]

## Basic project organization
- backend-modules: Backend modules for orderfy platform
- frontend-modules: Frontend modules for orderfy platform
- tpsource-modules: 3rd-party modules as source of external integrations
- insights-modules: Insights and analytics modules for orderfy platform
- quality-modules: Following Testing microservices by Martin Fowler
- toolbox-modules: Toolbox and common modules to keep orderfy up&running
- traffic-generator: A simple random traffic generator for orderfy platform
- scripts: Build and run tools


# Application Modules [wip]

- backend-modules/catalog-service: a wrapper service to [Akeneo PIM](https://www.akeneo.com/)
- backend-modules/checkout-service: a simple cart&checkout service by consuming discovery services
- backend-modules/customers-service: a customer-oriented MDM
- backend-modules/search-service: a thin Elastic-search wrapper, enabled by [Protobuf](https://github.com/google/protobuf) protocol
- toolbox-modules/discovery-service: a instance of Netflix OSS Eureka

## Run it
1. docker-compose up
2. Spring Cloud Eureka: http://localhost:9000/
3. Orderfy Backend Catalog Service: http://localhost:9001/
4. Orderfy Backend Customers Service: http://localhost:9002/
5. Orderfy Backend Checkout Service: http://localhost:9003/
6. Orderfy Backend Search Service: http://localhost:9004/
