package com.service.exhibitservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.service.exhibitservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .host("ctk0327.iptime.org:25000")
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("전시 서비스")
                .description("API 가이드 문서 (임시 작성 파일 API 호출등은 POSTMAN 이용 업데이트 예정)")
                .version("1.0.0")
                .build();
    }

//    private List<Response> responseBuilders() {
//        String[] codes = {"400", "401", "403", "404", "500"};
//        String[] descriptions = {"Bad Request", "Token Omission", "Forbidden", "Not Found", "Internal Server Error"};
//        List<Response> builders = new ArrayList<>();
//        for (int i = 0; i < codes.length; i++) {
//            builders.add(new ResponseBuilder()
//                    .code(codes[i])
//                    .description(descriptions[i])
//                    .build());
//        }
//
//        return builders;
//    }
}
