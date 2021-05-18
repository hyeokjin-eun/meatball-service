package com.service.swaggerservice.controller;

import com.service.swaggerservice.service.SwaggerService;
import com.service.swaggerservice.feign.InstanceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    private final SwaggerService swaggerService;

    public SwaggerController(SwaggerService swaggerService) {
        this.swaggerService = swaggerService;
    }

    @GetMapping("/self/update")
    public void getEurekaInstance() {
        swaggerService.swaggerApiUpdate();
    }

    @GetMapping("/service/{serviceName}")
    public String getServiceDefinition(@PathVariable String serviceName) {
        return swaggerService.getServiceDefinition(serviceName);
    }

    @GetMapping("/test")
    public String test() {
        return InstanceFeign.class.getTypeName();
    }
}
