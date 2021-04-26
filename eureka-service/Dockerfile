FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/local/eurekaserver
WORKDIR /usr/local/eurekaserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD ./run.sh