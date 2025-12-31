FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/PasteBin-0.0.1-SNAPSHOT.jar app.jar

# Render provides PORT dynamically
ENV PORT=10000
EXPOSE 10000

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
