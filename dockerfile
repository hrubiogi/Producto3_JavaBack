# Establecer la imagen base para la etapa de compilación
FROM maven:3.9.6 AS build-stage

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar pom.xml y source code
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src src

# Compilar y empaquetar la aplicación sin ejecutar pruebas unitarias
RUN mvn -B package --file pom.xml -DskipTests

# Establecer la imagen base para la etapa de ejecución
FROM openjdk:17

# Copiar el JAR desde la etapa de build
COPY --from=build-stage /app/target/*.jar app.jar

# Exponer el puerto donde corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]



