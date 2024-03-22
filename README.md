# Reto Intercorp Microservices

Este proyecto consta de varios microservicios implementados con Spring Boot y Docker. Cada microservicio tiene su propio propósito y funcionalidad.

## Microservicios

1. **DataStorageService**: Este microservicio se encarga de almacenar los datos.
2. **DataTransformerService**: Este microservicio se encarga de transformar los datos.
3. **DataViewerService**: Este microservicio se encarga de visualizar los datos.
4. **XMLReaderService**: Este microservicio se encarga de leer datos en formato XML.

## Ejecución de los Microservicios

Para ejecutar los microservicios, necesitarás Docker y Docker Compose instalados en tu máquina. Una vez instalados, puedes seguir los siguientes pasos:

1. Clona el repositorio: `git clone git@github.com:carlosorbegoso/reto-intercorp.git`
2. Navega al directorio del proyecto: `cd reto-intercorp`
3. Ejecuta el script de construcción: `./code.sh`
4. Inicia los servicios con Docker Compose: `docker-compose up`

Esto iniciará todos los microservicios y los servicios dependientes (como Kafka y Postgres) en contenedores Docker. Puedes acceder a los microservicios en los puertos especificados en el archivo `docker-compose.yml`.

## Detener los Microservicios

Para detener los microservicios y limpiar los recursos de Docker, puedes usar el siguiente comando:

`docker-compose down`