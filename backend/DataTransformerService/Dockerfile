FROM gradle:8.6-jdk as build
RUN gradle build --no-daemon
FROM openjdk:17-jdk-slim
LABEL authors="Carlos Orbegoso Loayza"
LABEL description="This is a Dockerfile for a Spring Boot application Data Transformer Service"
EXPOSE 8082
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]