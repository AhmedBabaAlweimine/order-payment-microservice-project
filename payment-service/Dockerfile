FROM openjdk:17
EXPOSE 8082
LABEL authors="aalweimine"
ADD target/payment-service-0.0.1-SNAPSHOT.jar  payment-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/payment-service-0.0.1-SNAPSHOT.jar"]