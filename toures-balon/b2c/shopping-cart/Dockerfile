#imagen base de java 8 con openjdk
FROM openjdk:8

#copiamos el jar del servicio REST al contenedor
COPY target/shopping-cart-0.0.1-SNAPSHOT.jar app.jar

#ejecuta el despliegue del servicio generado con Spring Boot
CMD java -jar app.jar

#expone el puerto de escucha del servidor
EXPOSE 8080
