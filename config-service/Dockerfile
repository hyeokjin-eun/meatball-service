FROM maven:3.3-jdk-8
RUN mkdir -p /usr/local/configserver
WORKDIR /usr/local/configserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD mvn clean package
CMD ./run.sh