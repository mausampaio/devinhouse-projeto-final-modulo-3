FROM openjdk:15-jdk-alpine

RUN mkdir app

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

COPY /devinhouse.mv.db ./

ENTRYPOINT ["java","-jar","app.jar"]