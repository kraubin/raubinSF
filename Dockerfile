FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build directory to the container
COPY build/libs/SalesForceAuto-all.jar app.jar

# Copy the feature files into the container
COPY src/test/resources /app/features

# Command to run the application
ENTRYPOINT ["java", "-cp", "app.jar:/app/features", "runners.TestRunner"]
