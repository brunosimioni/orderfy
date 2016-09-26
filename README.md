# orderfy

[![Build Status](https://travis-ci.org/brunosimioni/orderfy.svg?branch=master)](https://travis-ci.org/brunosimioni/orderfy)
[![Coverage Status](https://coveralls.io/repos/github/brunosimioni/orderfy/badge.svg)](https://coveralls.io/github/brunosimioni/orderfy)

A simple proof-of-technology for an ecommerce platform

- Spring Boot 1.4.0 testing
- Travis CI continuous integration
- Coveralls for static analysis and code lint
- Spring Cloud Netflix OSS (Eureka, Hystrix, Feign, Zuul, etc)
- Docker Compose for local deployment with wait-for-it dependencies
- Kubernetes for cloud-native deployment

## Run

1. docker-compose up

2. Spring Cloud Eureka: http://localhost:9000/
3. Orderfy Backend Catalog Service: http://localhost:9001/
3. Orderfy Backend Customers Service: http://localhost:9002/
3. Orderfy Backend Checkout Service: http://localhost:9003/