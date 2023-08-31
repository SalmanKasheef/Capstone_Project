FROM openjdk:17
ADD target/KafkaProject-0.0.1-SNAPSHOT.jar kafkaserver.jar
ENTRYPOINT ["java","-jar","kafkaserver.jar"]
EXPOSE 9999
