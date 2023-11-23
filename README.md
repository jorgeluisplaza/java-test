# java-test

# Requisitos

1. Gradle
2. Java

# Como iniciar proyecto

1. Clonar el repositorio
2. Abrir terminal en raiz del proyecto
3. Ejecutar comando ./gradlew bootRun

Al iniciar el proyecto, se genera la base de datos en memoria con H2. 

# Como probar

1. Ejecutar una solicitud a la url http://localhost:8080/api/users/register.
2. Rellenar el body correctamente

# Ejemplo de solicitud

curl --location 'http://localhost:8080/api/users/register' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "nombre del Usuario",
  "email": "test@gmail.com",
  "password": "Compadre_12",
  "phones": [
    {
      "number": "1234567",
      "cityCode": "1",
      "countryCode": "57"
    },
    {
      "number": "7654321",
      "cityCode": "2",
      "countryCode": "57"
    }
  ]
}'

# Base de datos

1. La base de datos se puede mirar en http://localhost:8080/h2-console/
2. Ingresar url: jdbc:h2:mem:testdb, username: sa y contraseña: password
