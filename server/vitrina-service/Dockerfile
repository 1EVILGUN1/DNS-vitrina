# Этап сборки
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Этап выполнения
FROM eclipse-temurin:21-jre-jammy
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY --from=builder /app/target/vitrina-service.jar vitrina-service.jar
ENV JAVA_OPTS="-Xmx400m -Xms200m"
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/vitrina-service.jar"]