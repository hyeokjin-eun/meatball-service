package com.service.gatewayservice.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Config {
    private boolean preLogger;

    private boolean postLogger;
}
