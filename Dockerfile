FROM openjdk:21 AS build
WORKDIR /mydir
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn ./.mvn

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests


FROM openjdk:21 AS runtime
WORKDIR /mydir
COPY --from=build /mydir/target/quarkus-app .
EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
