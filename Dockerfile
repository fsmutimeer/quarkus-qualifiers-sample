# FROM openjdk:21 AS build
# FROM maven:3.9.9-eclipse-temurin-21 AS build
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21 AS build
WORKDIR /mydir

COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn ./.mvn

# RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests


# FROM openjdk:21 AS runtime
# FROM eclipse-temurin:21-jre AS runtime
FROM bellsoft/liberica-runtime-container:jre-21-slim-musl
WORKDIR /mydir
COPY --from=build /mydir/target/quarkus-app .
EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
