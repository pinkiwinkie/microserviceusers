package com.helena.ruiz.users.microserviceusers.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
  info=@Info(
    title = "users api",
    version = "1.0.0",
    description = "Handles database information and users crud."
  )
)
public class SwaggerConfig {
  
}
