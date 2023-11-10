
FROM openjdk:11-jre-slim

WORKDIR /src

COPY target/tecnica-0.0.1-SNAPSHOT.jar tecnica-0.0.1-SNAPSHOT.jar


EXPOSE 8080

CMD ["java", "-jar", "tecnica-0.0.1-SNAPSHOT.jar"]
