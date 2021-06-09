package com.service.swaggerservice.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.service.swaggerservice.util.SwaggerUtil;
import com.service.swaggerservice.config.FeignConfig;
import com.service.swaggerservice.config.ServiceDefinitionsContext;
import com.service.swaggerservice.feign.InstanceFeign;
import com.service.swaggerservice.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwaggerService {

    private final EurekaClient eurekaClient;

    private final ServiceDefinitionsContext serviceDefinitionsContext;

    public SwaggerService(@Qualifier("eurekaClient") EurekaClient eurekaClient, ServiceDefinitionsContext serviceDefinitionsContext) {
        this.eurekaClient = eurekaClient;
        this.serviceDefinitionsContext = serviceDefinitionsContext;
    }

    public void swaggerApiUpdate() {
        eurekaClient.getApplications().getRegisteredApplications().forEach(application -> {
            List<InstanceInfo> instanceInfos = application.getInstances();
            if (instanceInfos != null && !instanceInfos.isEmpty()) {
                InstanceInfo instanceInfo = instanceInfos.get(0);
                if (!SwaggerUtil.isSwaggerService(instanceInfo.getAppName())) {
                    InstanceFeign instanceFeign = (InstanceFeign) FeignConfig.feignBuilder(InstanceFeign.class, instanceInfo.getVIPAddress());
                    String result = ObjectUtil.objectConvertJson(instanceFeign.getSwaggerJson());
                    serviceDefinitionsContext.addServiceDefinition(instanceInfo.getAppName(), result);
                }

            }
        });
    }

    public String getServiceDefinition(String serviceName) {
        return serviceDefinitionsContext.getSwaggerDefinition(serviceName);
    }
}
