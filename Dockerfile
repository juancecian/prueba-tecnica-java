# Utiliza una imagen base de OpenJDK para Java 11
FROM openjdk:11-jre-slim

# Directorio de trabajo en el contenedor
WORKDIR /src

# Copia el archivo JAR construido y cualquier otro recurso necesario
COPY target/tecnica-0.0.1-SNAPSHOT.jar tecnica-0.0.1-SNAPSHOT.jar

# Puerto en el que la aplicación escucha (ajusta según tu aplicación)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "tecnica-0.0.1-SNAPSHOT.jar"]
