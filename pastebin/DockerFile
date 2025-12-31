FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/PasteBin-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
