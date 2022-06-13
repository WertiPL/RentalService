package com.example.rentalservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.rentalservice"))
                .build();
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Rental Service API",
                "Movie database",
                "1.00",
                "http://bykowski.pl",
                new Contact("Wiktor Rostkowski", "http://vvrw.eu", "wiktor@vvwi.eu"),
                "GUI",
                "",
                Collections.emptyList()
        );
    }
}
