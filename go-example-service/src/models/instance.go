package models

import "net"

type Instance struct {
	HostName         net.IP `json:"hostName"`
	App              string `json:"app"`
	IpAddr           net.IP `json:"ipAddr"`
	VipAddress       string	`json:"vipAddress"`
	SecureVipAddress string	`json:"secureVipAddress"`
	Status           string `json:"status"`
	Port			 int	`json:"port"`
	SecurePort		 int	`json:"securePort"`
	HomePageUrl		 string	`json:"homePageUrl"`
	StatusPageUrl	 string	`json:"statusPageUrl"`
	HealthCheckUrl	 string	`json:"healthCheckUrl"`
}
