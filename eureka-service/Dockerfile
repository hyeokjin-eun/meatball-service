FROM maven:3.3-jdk-8
RUN mkdir -p /usr/local/eurekaserver
WORKDIR /usr/local/eurekaserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh