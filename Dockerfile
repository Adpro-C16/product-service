FROM gradle:7.2.0-jdk17 AS build
COPY . .
RUN gradle build --no-daemon

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/product_service-0.0.1-SNAPSHOT.jar product_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","product_service.jar"]