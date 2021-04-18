# <center> Meatball Service </center>
## 목차
  * [소개](#소개)
  * [모듈](#모듈)
  * [실행](#실행)

## 소개
Meatball Microservice Server Project

## 모듈
| Module                                                                                           | PORT | Description                | 
|--------------------------------------------------------------------------------------------------|------|----------------------------|
| [eureka-service](https://github.com/hyeokjin-eun/meatball-service/tree/master/eureka-service)    | 8761 | API Discovery Service      |
| [config-service](https://github.com/hyeokjin-eun/meatball-service/tree/master/config-service)      | 8888 | API Config Service          |
| [gateway-service](https://github.com/hyeokjin-eun/meatball-service/tree/master/gateway-service)  | 5000 | API Gateway Service        |
| [example-service](https://github.com/hyeokjin-eun/meatball-service/tree/master/example-service)  | 8081 | Rest API Example Service   |

## 실행
  ```console
    $ cd PROJECT_HOME
    $ docker-compose up -d
  ```