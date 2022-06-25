FROM maven:3.8.6-jdk-11-slim
COPY "./target/docker-back.jar" "app.jar"
COPY "./Usuarios.json" "/Usuarios.json"
COPY "./Equipos.json" "/Equipos.json"
COPY "./Prestamos.json" "/Prestamos.json"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]