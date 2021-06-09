package com.service.ingredientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.service.ingredientservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .host("ctk0327.iptime.org:25000/ingredientservice")
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, responseBuilders())
                .globalResponses(HttpMethod.POST, responseBuilders())
                .globalResponses(HttpMethod.PUT, responseBuilders())
                .globalResponses(HttpMethod.DELETE, responseBuilders());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("전시 서비스")
                .description("API 가이드 문서")
                .version("1.0.0")
                .build();
    }

    private List<Response> responseBuilders() {
        String[] codes = {"400", "401", "403", "404", "500"};
        String[] descriptions = {"Bad Request", "Token Omission", "Forbidden", "Not Found", "Internal Server Error"};
        List<Response> builders = new ArrayList<>();
        for (int i = 0; i < codes.length; i++) {
            builders.add(new ResponseBuilder()
                    .code(codes[i])
                    .description(descriptions[i])
                    .build());
        }

        return builders;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
}
