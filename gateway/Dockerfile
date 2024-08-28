FROM openjdk:17
EXPOSE 8090
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]