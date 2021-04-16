FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/gatewayserver
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} /usr/local/gatewayserver
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh