package com.service.swaggerservice.util;

import java.util.Objects;

public class SwaggerUtil {
    public static String[] SWAGGER_IGNORE_SERVICE = {"CONFIGSERVICE", "GATEWAYSERVICE", "SWAGGERSERVICE"};

    public static boolean isSwaggerService(String appName) {
        for (String s : SWAGGER_IGNORE_SERVICE) {
            if (Objects.equals(appName, s)) {
                return true;
            }
        }

        return false;
    }
}
