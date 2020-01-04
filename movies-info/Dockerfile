FROM maven:3.5-jdk-8-alpine as build
COPY ./ ./
WORKDIR /movies-info

RUN mvn install


FROM openjdk:8u131-jdk-alpine
ADD /movies-info/target/movies-info-0.0.1-SNAPSHOT.jar app-movies-info.jar
ENTRYPOINT ["java","-jar","/app-movies-info.jar"]