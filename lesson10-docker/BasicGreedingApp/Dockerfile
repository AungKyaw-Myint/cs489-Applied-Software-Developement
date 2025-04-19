FROM amazoncorretto:23-alpine
LABEL authors="DELL"

# Set the working directory in Docker
WORKDIR /app

# Copy the local build jar file to working directory of Docker
COPY build/libs/myapp-1.0.1.jar /app

# run the jar file
ENTRYPOINT ["java", "-jar", "myapp-1.0.1.jar"]