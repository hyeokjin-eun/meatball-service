package com.service.swaggerservice.config;

import io.swagger.annotations.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@Scope(name = ConfigurableBeanFactory.SCOPE_SINGLETON, description = "Swagger Configuration")
public class ServiceDefinitionsContext {
    private final ConcurrentHashMap<String, String> serviceDescriptions;

    public ServiceDefinitionsContext() {
        this.serviceDescriptions = new ConcurrentHashMap<>();
    }

    public void addServiceDefinition(String serviceName, String serviceDescription) {
        serviceDescriptions.put(serviceName, serviceDescription);
    }

    public String getSwaggerDefinition(String serviceId) {
        return this.serviceDescriptions.get(serviceId);
    }

    public List<SwaggerResource> getSwaggerDefinitions() {
        return serviceDescriptions.keySet().stream().map(s -> {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setLocation("/service/" + s);
            swaggerResource.setName(s);
            swaggerResource.setSwaggerVersion("2.0");
            return swaggerResource;
        }).collect(Collectors.toList());
    }
}
