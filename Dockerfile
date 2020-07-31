FROM openjdk:8-jdk-slim

COPY target/redis-stream-consumer-demo-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src
ENTRYPOINT ["java","-jar","/usr/src/redis-stream-consumer-demo-0.0.1-SNAPSHOT.jar"]
