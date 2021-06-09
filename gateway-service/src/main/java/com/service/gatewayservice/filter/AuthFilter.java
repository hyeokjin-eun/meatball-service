package com.service.gatewayservice.filter;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.service.gatewayservice.model.dto.response.UserResponseDto;
import com.service.gatewayservice.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Component
public class AuthFilter extends AbstractGatewayFilterFactory<Config> {

    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;

    public AuthFilter(@Qualifier("eurekaClient") EurekaClient eurekaClient, RestTemplate restTemplate) {
        super(Config.class);
        this.eurekaClient = eurekaClient;
        this.restTemplate = restTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.isPreLogger()) {
                InstanceInfo instanceInfo;
                try {
                    instanceInfo = eurekaClient.getApplications().getRegisteredApplications("AUTH-CLIENT").getInstances().get(0);
                } catch (Exception e) {
                    return returnInternalServerError(exchange);
                }

                if (instanceInfo == null) {
                    return returnInternalServerError(exchange);
                }

                boolean isCheck = tokenCheck(exchange, instanceInfo);
                if (!isCheck) {
                    return returnUnAuthorized(exchange);
                }
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    postFilter();
                }
            }));
        };
    }

    private boolean tokenCheck(ServerWebExchange exchange, InstanceInfo instanceInfo) {
        boolean isCheck = true;
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        if (!httpHeaders.containsKey("Authorization") || !httpHeaders.containsKey("user")) {
            isCheck = false;
        }

        String token = Objects.requireNonNull(httpHeaders.get("Authorization")).get(0);
        String user = Objects.requireNonNull(httpHeaders.get("user")).get(0);
        Long userId = getUserId(instanceInfo, user, token);
        if (userId == null) {
            isCheck = false;
        }

        exchange.getRequest().getHeaders().set("userId", String.valueOf(userId));

        return isCheck;
    }

    private Long getUserId(InstanceInfo instanceInfo, String user, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.set("user", user);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<UserResponseDto> userResponseDto = restTemplate.exchange(
                StringUtil.getInstanceHost(instanceInfo) + "/member",
                HttpMethod.GET,
                httpEntity,
                UserResponseDto.class
        );
        if (!Objects.equals(userResponseDto.getStatusCode(), HttpStatus.OK)) {
            return null;
        }

        if (userResponseDto.getBody() == null) {
            return null;
        }

        return userResponseDto.getBody().getId();
    }

    private void postFilter() {
    }

    private Mono<Void> returnUnAuthorized(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    private Mono<Void> returnInternalServerError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return response.setComplete();
    }
}
