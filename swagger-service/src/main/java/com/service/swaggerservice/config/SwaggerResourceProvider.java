package com.service.swaggerservice.config;

import com.service.swaggerservice.config.ServiceDefinitionsContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerResourceProvider implements SwaggerResourcesProvider {

    private final ServiceDefinitionsContext serviceDefinitionsContext;

    public SwaggerResourceProvider(ServiceDefinitionsContext serviceDefinitionsContext) {
        this.serviceDefinitionsContext = serviceDefinitionsContext;
    }

    @Override
    public List<SwaggerResource> get() {
        return new ArrayList<>(serviceDefinitionsContext.getSwaggerDefinitions());
    }
}
