FROM openjdk:21
EXPOSE 8080
ADD target/Weather-0.0.1-SNAPSHOT.jar wx_svc.jar
ENTRYPOINT ["java", "-jar", "wx_svc.jar"]