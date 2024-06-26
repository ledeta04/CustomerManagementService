package com.craft.CustomerManagementService.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateCustomer {
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
}
