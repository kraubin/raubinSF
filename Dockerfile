# Use an official OpenJDK image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the local machine to the container
COPY build/libs/SalesForceAuto-1.0-SNAPSHOT.jar myapp.jar

# Command to run the application
CMD ["java", "-jar", "myapp.jar"]
