# Use a valid OpenJDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built jar (make sure it exists in target/)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Render provides PORT dynamically
ENV PORT=10000
EXPOSE 10000

# Run the jar with dynamic port
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
