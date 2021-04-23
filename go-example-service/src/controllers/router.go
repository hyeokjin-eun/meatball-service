package controllers

import (
	"github.com/gin-gonic/gin"
)

func Router()  {
	// Release Mode
	//gin.SetMode(gin.ReleaseMode)
	r := gin.Default()

	// COMMON
	r.GET("/", HealthCheck)
	r.GET("/instance", GetInstance)
	r.GET("/eureka/instance", GetEurekaInstance)
	r.Run(":3000")
}