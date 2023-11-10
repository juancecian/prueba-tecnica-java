# Documentación del Proyecto

## Descripción del Proyecto

Este proyecto Java utiliza Spring Boot como framework principal, Lombok para la simplificación del código, Gson para la manipulación de datos en formato JSON y H2 Database como base de datos embebida. Además, se incluyen pruebas unitarias simples para garantizar la respuesta esperada de los servicios.

## Requisitos Previos

Asegúrese de tener instalado Java y Maven en su sistema antes de ejecutar este proyecto.

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

## Configuración del Proyecto

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/tu-proyecto.git](https://github.com/juancecian/prueba-tecnica-java.git
   ```

2. **Compilar el Proyecto:**
   ```bash
   mvn clean install
   ```

## Ejecución del Proyecto

1. **Ejecutar la Aplicación:**
   ```bash
   mvn spring-boot:run
   ```

   La aplicación estará disponible en `http://localhost:8080`.

2. **Endpoints Disponibles:**
   - `/manufacturers`: Devuelve un listado de manufacturers con todo su detalle
     - `/manufacturers?format=json`: Indica que la información se responderá en formato JSON
     - `/manufacturers?commonName=Tesla`: Hace un filtrado en la información que es devuelta, filtrando por el atributo Mfr_CommonName.

## Estructura del Proyecto

La estructura del proyecto sigue las convenciones de un proyecto Spring Boot:

- `src/main/java`: Contiene el código fuente de la aplicación.
  - `com.prueba.tecnica`: Paquete principal.
    - `configurations`: Configuraciones de la aplicación.
    - `controllers`: Controladores de los endpoints.
    - `model`: Entities de la aplicación.
    - `dto`: Modelos comunes usados como respuesta en los servicios.
    - `service`: Repositorio de JPA.
    - `service.impl`: Lógica de negocio.
- `src/test/java`: Contiene las pruebas unitarias.
  - `com.prueba.tecnica`: Paquete de pruebas.

## Uso de Lombok

Este proyecto utiliza Lombok para reducir la verbosidad del código. Asegúrese de tener el complemento Lombok instalado en su IDE para un correcto funcionamiento.

## Pruebas Unitarias

Se han incluido pruebas unitarias para garantizar la integridad y el correcto funcionamiento de las funciones clave del proyecto. Para ejecutar las pruebas, utilice el siguiente comando:

```bash
mvn test
```

## Tecnologías Principales Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot): Framework para el desarrollo de aplicaciones Java basadas en el principio de convención sobre configuración.
- [Lombok](https://projectlombok.org/): Biblioteca que agiliza el desarrollo eliminando la necesidad de escribir código boilerplate.
- [Gson](https://github.com/google/gson): Biblioteca para la serialización y deserialización de objetos Java a JSON.
- [H2 Database](https://www.h2database.com/): Base de datos embebida escrita en Java.

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).
