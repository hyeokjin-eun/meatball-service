FROM maven:3.8.1-ibmjava-8-alpine
RUN mkdir -p /usr/local/eurekaserver
WORKDIR /usr/local/eurekaserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh