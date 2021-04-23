FROM maven:3.8.1-ibmjava-8-alpine
RUN mkdir -p /usr/local/gatewayserver
WORKDIR /usr/local/gatewayserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh