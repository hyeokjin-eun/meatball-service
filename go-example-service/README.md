# <center> Gateway Server </center>
## 목차
* [소개](#소개)
* [스펙](#스펙)
* [할일](#할일)
* [설치](#설치)
* [빌드](#빌드)
* [실행](#실행)

## 소개
Meatball Microservice Go Example Server Module

## 스펙
* [GoLang]()
* [Go mod]()
* [Go gin]()

## 할일


## 설치
  * Go Install
  ```
    $ apt install wget
    $ cd /usr/local
    $ wget https://dl.google.com/go/go1.11.linux-amd64.tar.gz
    $ tar -xvf go1.11.linux-amd64.tar.gz
    $ rm go1.11.linux-amd64.tar.gz
  ```
  * Go Environment variable setting
  ```
    $ vi ~/.bash_profile
    export GOROOT=/usr/local/go
    export GOPATH=$HOME/go
    export PATH=$GOPATH/bin:$GOROOT/bin:$PATH
    $ source ~/.bash_profile
  ```
  * Go version
  ```
    $ go version
  ```

## 빌드
  ```console
    $ cd PROJECT_HOME
    $ docekr build -t goexampleserver:0.1 .
  ```

## 실행
  ```console
    $ cd PROJECT_HOME
    $ docker-compose up
  ```