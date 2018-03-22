FROM openjdk:9
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-server.jar"]
