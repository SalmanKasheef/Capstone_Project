FROM openjdk:17
ADD target/Config-Server-0.0.1-SNAPSHOT.jar configserver.jar
ENTRYPOINT ["java","-jar","configserver.jar"]
EXPOSE 8888