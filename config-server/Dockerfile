FROM openjdk:16-jdk-alpine
LABEL MAINTAINER="https://github.com/senoritadeveloper01"
LABEL APPLICATION="Cloud Config Server"
WORKDIR /usr/app
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server-0.0.1-SNAPSHOT.jar
# ADD src/main/resources/application.properties application.properties
# ADD src/main/resources/city-score-dev.properties city-score-dev.properties
# ,"-Dspring.config.location=file:application.properties"
ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888