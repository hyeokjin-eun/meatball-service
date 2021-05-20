package com.service.gatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class DefaultFilter extends AbstractGatewayFilterFactory<Config> {

    public DefaultFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.isPreLogger()) {
                preFilter(exchange);
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    postFilter();
                }
            }));
        };
    }

    private void preFilter(ServerWebExchange exchange) {
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        List<String> authorization = httpHeaders.get("Authorization");
        String userId = null;
        if (authorization != null && !authorization.isEmpty()) {
            for (String auth : authorization) {
                if (auth.contains("bearer")) {
                    userId = auth;
                }
            }
        }
    }

    private void postFilter() {
    }
}
