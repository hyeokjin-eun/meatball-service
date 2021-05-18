package com.service.swaggerservice.config;

import com.service.swaggerservice.feign.InstanceFeign;
import feign.Contract;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder();
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder();
    }

    public static Object feignBuilder(Class<InstanceFeign> target, String url) {
        return Feign.builder()
                .contract(new Contract.Default())
                .retryer(new Retryer.Default())
                .options(new Request.Options(1000, 1000))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .decode404()
                .target(target, url);
    }
}
