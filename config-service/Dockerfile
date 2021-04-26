FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/configserver
WORKDIR /usr/local/configserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD ./run.sh