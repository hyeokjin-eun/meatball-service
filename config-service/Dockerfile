FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/local/configserver
WORKDIR /usr/local/configserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh