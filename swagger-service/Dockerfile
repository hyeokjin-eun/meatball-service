FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/swaggerserver
WORKDIR /usr/local/swaggerserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD ./run.sh