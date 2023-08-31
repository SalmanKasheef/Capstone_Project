FROM openjdk:17
ADD target/*.jar reviewservice.jar
ENTRYPOINT ["java","-jar","reviewservice.jar"]
EXPOSE 8083