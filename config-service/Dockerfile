FROM maven:3.8.1-ibmjava-8-alpine
RUN mkdir -p /usr/local/configserver
WORKDIR /usr/local/configserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh