# Build stage
FROM gradle:8.6-jdk as build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build --no-daemon

# Package stage
FROM openjdk:17-jdk-slim
LABEL authors="Carlos Orbegoso Loayza"
LABEL description="This is a Dockerfile for a Spring Boot application Data Storage Service"
EXPOSE 8081
COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]