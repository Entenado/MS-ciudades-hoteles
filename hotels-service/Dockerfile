FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/hoteles-0.0.1.jar
COPY ${JAR_FILE} app_hotels.jar
ENTRYPOINT ["java", "-jar", "app_hotels.jar"]