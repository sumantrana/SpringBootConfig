FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG JAR_FILE
COPY target/springbootconfig-0.0.1-SNAPSHOT.jar /springbootconfig-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/springbootconfig-0.0.1-SNAPSHOT.jar"]