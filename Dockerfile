# Use the official OpenJDK image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/PersonalFinanceTracker-0.0.1-SNAPSHOT.jar /app/PersonalFinanceTracker.jar

# Expose the port the app will run on
EXPOSE 8080

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "PersonalFinanceTracker.jar"]