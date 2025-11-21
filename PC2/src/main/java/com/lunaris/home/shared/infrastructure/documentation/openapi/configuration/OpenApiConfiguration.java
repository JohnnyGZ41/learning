package com.lunaris.home.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Lunaris Platform API")
                        .description("Lunaris Platform Application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}