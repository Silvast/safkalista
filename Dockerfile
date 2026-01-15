FROM clojure:temurin-21-lein AS builder
WORKDIR /app
COPY project.clj .
RUN lein deps
COPY . .
RUN lein uberjar

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/uberjar/server.jar .
COPY --from=builder /app/resources ./resources
EXPOSE 3001
CMD ["java", "-jar", "server.jar"]
