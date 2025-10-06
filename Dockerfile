# Dockerfile

# STAGE 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom files and download dependencies to leverage Docker layer caching
COPY pom.xml .
COPY basic-webapp/pom.xml ./basic-webapp/
COPY performance-test/pom.xml ./performance-test/
RUN mvn dependency:go-offline -B

# Copy the source code
COPY ./basic-webapp ./basic-webapp
COPY ./performance-test ./performance-test

# Package only the webapp module, skipping tests
RUN mvn package -DskipTests -pl basic-webapp

# STAGE 2: Create the final, slim image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the executable JAR from the builder stage
COPY --from=builder /app/basic-webapp/target/basic-webapp-*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]