package com.example.docCrud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // <-- Anotação @Configuration na CLASSE
public class SwaggerConfig {

    @Bean // <-- Anotação @Bean no MÉTODO
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Documentos (docCrud)")
                        .version("1.0")
                        .description("API para gerenciamento de documentos."));
    }
}