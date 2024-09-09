FROM openjdk:17

EXPOSE 8080
EXPOSE 9000

ADD ./target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
