FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/ingredientserver
WORKDIR /usr/local/ingredientserver
ADD ./ ./
RUN chmod +x ./run.sh
CMD ./run.sh