FROM openjdk:17

EXPOSE 8761
EXPOSE 9000

ADD ./target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
