#### Stage 1: Build the movies-infolication
# our base build image
FROM maven:3.5-jdk-8 as maven

# Set the current working directory inside the image
WORKDIR /movies-info
RUN chmod -R 777 mvnw 
# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.

RUN mvn dependency:go-offline -B

# Copy the project source
COPY src src

# Package the movies-infolication

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