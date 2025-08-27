FROM openjdk:21 AS build
WORKDIR /afsana
COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests


FROM openjdk:21 AS runtime
WORKDIR /afasana
COPY --from=build /afsana/target/quarkus-app .
EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
