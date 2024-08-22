FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/ciudades-0.0.1.jar
COPY ${JAR_FILE} app_city.jar
ENTRYPOINT ["java", "-jar", "app_city.jar"]