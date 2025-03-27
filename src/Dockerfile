FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Kopiraj sve fajlove
COPY . .

# Dodeli dozvole za izvršavanje mvnw skripte
RUN chmod +x ./mvnw

# Pokreni Maven build
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/Igra-0.0.1-SNAPSHOT.jar Igra.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Igra.jar"]
