package com.service.gatewayservice.util;

import com.netflix.appinfo.InstanceInfo;

import java.util.Objects;

public class StringUtil {

    public static String getInstanceHost(InstanceInfo instanceInfo) {
        //TODO docker-compose 파일 연결되면 주석 해제
        /*if (instanceInfo.getVIPAddress() == null || Objects.equals(instanceInfo.getVIPAddress(), "")) {
            return "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
        }

        return "http://" + instanceInfo.getVIPAddress() + ":" + instanceInfo.getPort();*/

        return "http://ctk0327.iptime.org:20080";
    }
}
