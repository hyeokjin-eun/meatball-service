# <center> Config Server </center>
## 목차
* [소개](#소개)
* [스펙](#스펙)
* [할일](#할일)
* [설치](#설치)
* [빌드](#빌드)
* [실행](#실행)

## 소개
Meatball Microservice Config Server Module

## 스펙
* [Maven](https://mvnrepository.com/)
* [Java 8](https://docs.oracle.com/javase/8/docs/api/)
* [Spring Boot 2.4](https://spring.io/projects/spring-boot)
* [Spring Cloud Eureka Client](https://spring.io/projects/spring-cloud-netflix)
* [Spring Cloud Config Server](https://spring.io/projects/spring-cloud-config)

## 할일
* Docker Maven Plugin 연결

## 설치
  * Java Install
  ```console
    $ sudo yum install java-1.8.0-openjdk-devel
  ```
  * Java Version
  ```console
    $ java -version
  ```
  <br>

  * Maven Install
  ```console
    $ wget http://mirror.apache-kr.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
    $ tar -xvf apache-maven-3.6.3-src.tar.gz
  ```
  * Maven Environment variable setting
  ```
    $ vi ~/.bash_profile
    export MAVEN_HOME=/usr/local/maven
    PATH=$PATH:$HOME/bin:$MAVEN_HOME/bin
    export PATH
    $ source ~/.bash_profile
  ```
  * Maven version
  ```
    $ mvn -v
  ```

## 빌드
  ```console
    $ cd PROJECT_HOME
    $ mvn clean package
    $ docker build -t configserver:0.1 .
  ```

## 실행
  ```console
    $ cd PROJECT_HOME
    $ docker run -d configserver:0.1
  ```