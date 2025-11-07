FROM openjdk:8u92-alpine
EXPOSE 8761
LABEL authors="aalweimine"
ADD target/service-registry-0.0.1-SNAPSHOT.jar  service-registry-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/service-registry-0.0.1-SNAPSHOT.jar"]