# Spring-Protocols

Goals:
- First test - No virtual Threads
- Second test - Virtual Threads
- Third test - Reactive (Rsocket) + Virtual Threads

One maven project for the API
Docker container for the wiremock stuff
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

You are an experienced software engineer with years of experience working on Spring and performance testing frameworks. You are to complete the below steps. 
I have a multi module pom project. The basic-webapp project essentially creates an HTTP web server which serves only 1 type of request, as seen below:
curl -X POST http://localhost:8080/transform
-H "Content-Type: application/json"
-d '{"message": "Hello, World!"}'

I want to performance test this API. I want to run a performance test with X number of TPS for Y seconds.
In the performance-test module, the main java folders are empty but there are already some test files. Feel free to change or alter the structure of these files as much as you need, they are just test code.

Add the karate-gatling framework to achieve the above test requirements, where the necessary variables are configurable.

Ensure simplistic and understandable configurations, where config files are neatly organized and everything is named understandably. 