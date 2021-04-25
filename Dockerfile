FROM adoptopenjdk/openjdk16

ADD target/SD-JPA1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]