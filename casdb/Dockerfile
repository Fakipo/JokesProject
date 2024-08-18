# Use the official Maven image with JDK 21 to build the application
FROM maven:3.9.8-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official Amazon Corretto 21 runtime image to run the application
FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /app/target/casdb-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
