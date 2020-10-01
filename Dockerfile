FROM maven:3-jdk-11-slim as builder

COPY . /usr/src/moneymanager-backend

WORKDIR /usr/src/moneymanager-backend

RUN mvn package spring-boot:repackage

FROM openjdk:11-jdk-slim

RUN addgroup --system spring && adduser --system --disabled-password --gecos '' --ingroup spring spring

USER spring:spring

WORKDIR /usr/moneymanager-backend

COPY --from=builder /usr/src/moneymanager-backend/target/moneymanager-backend.jar .

CMD ["java", "-jar", "moneymanager-backend.jar"]

