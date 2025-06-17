# Etapa 1: construir o JAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY src/main/java/br/com/controlefinanceiro .
RUN mvn clean package -DskipTests

# Etapa 2: rodar o JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta
EXPOSE 8080

# Executa o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]