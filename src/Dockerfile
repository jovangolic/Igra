# Use an official OpenJDK image for building the app
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

# Copy all files to the container
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the application using Maven (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# Use a smaller JDK image to run the app
FROM openjdk:17-jdk-slim

# Copy the jar file from the build image
COPY --from=build /app/target/Igra-0.0.1-SNAPSHOT.jar Igra.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/Igra.jar"]
