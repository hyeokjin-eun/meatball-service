FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/local/gatewayserver
WORKDIR /usr/local/gatewayserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh