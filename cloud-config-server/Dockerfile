FROM openjdk:8u92-alpine
EXPOSE 8081
LABEL authors="aalweimine"
ADD target/cloud-config-server-0.0.1-SNAPSHOT.jar  cloud-config-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/cloud-config-server-0.0.1-SNAPSHOT.jar"]