# Dockerfile
FROM openjdk:17-jdk-slim
COPY target/incident-app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
