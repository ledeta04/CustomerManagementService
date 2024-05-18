package com.craft.CustomerManagementService.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerOpenApiDoc {
	
	@Bean
	public OpenAPI openAPI() {
		
		return new OpenAPI().info(new Info().title("CustomerManagementService API")
				.version("1.0")
				.description("This is Customer Management Service Api document")
				.contact(new Contact()
				.name("Ashenafi C")
				.email("kingMenelik@gmail.com")));
	}

}
