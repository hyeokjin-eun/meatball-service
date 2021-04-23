package controllers

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"go-example-service/middlewares"
	"go-example-service/models"
	"log"
	"net"
)

func HealthCheck(c *gin.Context) {
	c.JSON(200, gin.H{
		"message": "Hello Go",
	})
}

func GetInstance(c *gin.Context)  {
	conn, err := net.Dial("udp", "8.8.8.8:80")
	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()
	localAddress := conn.LocalAddr().(*net.UDPAddr)

	var instance models.Instance
	instance.HostName = localAddress.IP
	instance.App = "GOEXAMPLESERVER"
	instance.IpAddr = localAddress.IP
	instance.Port = 3000

	log.Println("Test : {}", instance)
	c.JSON(200, instance)
}

func GetEurekaInstance(c *gin.Context)  {
	url := ""
	str := middlewares.HttpGet(url, true)
	fmt.Println(str)
}