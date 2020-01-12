#FROM openjdk:8u131-jdk-alpine
#ADD /movies-info/target/movies-info-0.0.1-SNAPSHOT.jar movies-info-authentication.jar
#ENTRYPOINT ["java",","-jar","/movies-info-authentication.jar"]

#### Stage 1: Build the movies-infolication
FROM openjdk:8-jdk-alpine as build

# Set the current working directory inside the image
WORKDIR /movies-info

# Copy maven executable to the image

COPY mvnw . 
COPY .mvn .mvn 

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.
RUN chmod -R 777 mvnw
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the movies-info

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the movies-info 
FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/movies-info/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /movies-info/lib
COPY --from=build ${DEPENDENCY}/META-INF /movies-info/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /movies-info

ENTRYPOINT ["java","-cp","movies-info:movies-info/lib/*","com.movies.info.MoviesApplication"]