# ====== Build stage ======
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw || true
RUN ./mvnw -DskipTests clean package

# ====== Run stage ======
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENV SPRING_ARGS=""
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar $SPRING_ARGS"]
