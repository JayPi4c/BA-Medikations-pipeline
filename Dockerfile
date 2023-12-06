FROM maven:3.9.5-eclipse-temurin-17 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:resolve

COPY src src
RUN mvn -B package

FROM openjdk:17.0.2

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]