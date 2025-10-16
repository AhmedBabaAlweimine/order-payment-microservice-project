FROM openjdk:8
EXPOSE 9195
LABEL authors="aalweimine"
ADD target/hystrix-dashboard-0.0.1-SNAPSHOT.jar  hystrix-dashboard-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/hystrix-dashboard-0.0.1-SNAPSHOT.jar"]