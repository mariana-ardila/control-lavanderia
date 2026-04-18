package com.example.control_lavanderia.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI adopcionOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Control de Lavanderíá")
                        .description("""
                                Backend para un sistema de control de lavandería.
                                
                                Permite administrar **Clientes**, **Órdenes** y **Prendas** con:
                                - Relaciones JPA (One-to-Many, Many-to-One)
                                - Enumeraciones (@Enumerated)
                                - Lógica de negocio en servicios
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@adopcion.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
