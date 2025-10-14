# Spring-Protocols

Goals:
- First test - No virtual Threads
- Second test - Virtual Threads
- Third test - Reactive (Rsocket) + Virtual Threads

One maven project for the API

Docker container for the wiremock 

instrument the API and get the results

Curl requests:

API

curl -X POST http://localhost:8080/transform \
-H "Content-Type: application/json" \
-d '{"message": "Hello, World!"}'

Mock API


curl -X POST http://localhost:8081/external \
-H "Content-Type: application/json" \
-d '{"message": "hello"}'

./mvnw spring-boot:run -pl basic-webapp