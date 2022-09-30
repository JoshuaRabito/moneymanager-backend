FROM openjdk:17-oracle

ARG JAR_FILE=target/*.jar
ARG PROPS_FILE=src/main/resources/application.properties
COPY ${JAR_FILE} app.jar
COPY ${PROPS_FILE} app.properties

ENTRYPOINT  ["java", "-jar","app.jar", "--spring.config.location=file:app.properties"]