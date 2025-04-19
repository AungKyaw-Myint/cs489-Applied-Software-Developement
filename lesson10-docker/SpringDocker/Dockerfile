FROM amazoncorretto:21-alpine
LABEL authors="DELL"

WORKDIR /app

COPY build/libs/SpringDocker-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "SpringDocker-0.0.1-SNAPSHOT.jar"]