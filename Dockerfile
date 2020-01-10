FROM maven:3-jdk-11-slim as builder

COPY . /usr/src/MyMoneyManager-backend

WORKDIR /usr/src/MyMoneyManager-backend

RUN mvn package spring-boot:repackage

FROM openjdk:11-jdk-slim

RUN addgroup --system spring && adduser --system --disabled-password --gecos '' --ingroup spring spring

USER spring:spring

WORKDIR /usr/MyMoneyManager-backend

COPY --from=builder /usr/src/MyMoneyManager-backend/target/backend-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]

