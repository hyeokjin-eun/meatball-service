package com.service.swaggerservice.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "instanceFeign")
public interface InstanceFeign {

    @RequestLine("GET /v2/api-docs")
    Object getSwaggerJson();
}
