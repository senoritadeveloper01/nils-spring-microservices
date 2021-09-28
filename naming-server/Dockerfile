FROM openjdk:16-jdk-alpine
LABEL MAINTAINER="https://github.com/senoritadeveloper01"
LABEL APPLICATION="Naming Server"
WORKDIR /usr/app
COPY target/naming-server-0.0.1-SNAPSHOT.jar naming-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","naming-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 8000