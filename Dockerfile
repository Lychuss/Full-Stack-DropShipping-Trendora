# ====== Build stage ======
FROM maven:3.9.8-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml first to leverage Docker cache
COPY BackEnd/pom.xml .

# Copy source code
COPY BackEnd/src ./src

# Build the project (skip tests)
RUN mvn -DskipTests clean package

# ====== Run stage ======
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Optional environment variables
ENV JAVA_OPTS=""
ENV SPRING_ARGS=""

# Start the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar $SPRING_ARGS"]
