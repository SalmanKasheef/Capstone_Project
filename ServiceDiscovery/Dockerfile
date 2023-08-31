FROM openjdk:17
ADD target/*.jar servicediscovery.jar
ENTRYPOINT ["java","-jar","servicediscovery.jar"]
EXPOSE 8761