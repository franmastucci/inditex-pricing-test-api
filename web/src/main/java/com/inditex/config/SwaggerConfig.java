package com.inditex.config;

import com.fasterxml.classmate.TypeResolver;
import com.inditex.price.dto.error.ErrorListMessageDTO;
import com.inditex.price.dto.error.ErrorMessageDTO;
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
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(ErrorMessageDTO.class),
                        typeResolver.resolve(ErrorListMessageDTO.class)
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inditex"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("inditex pricing test api")
                .description("API for search prices")
                .version("1.0")
                .build();
    }
}
