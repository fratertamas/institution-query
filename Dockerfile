FROM openjdk:8-jdk
COPY target/institution-query-*.jar usr/src/institution-query.jar
WORKDIR /usr/src/
ENTRYPOINT java -jar institution-query.jar