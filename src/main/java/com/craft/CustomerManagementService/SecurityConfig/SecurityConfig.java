package com.craft.CustomerManagementService.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("Menelik")
				
				.password(encoder.encode("1234"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("Taitu")
				
				.password(encoder.encode("123456"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin , user);
					
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return 
				httpSecurity
				.authorizeHttpRequests().requestMatchers("/leads/create/**").authenticated()
				.and()
				.authorizeHttpRequests().requestMatchers("/customers/create/**").authenticated()
				.and()
				.authorizeHttpRequests().requestMatchers("/customers/update/**").authenticated()
				.and()
				.authorizeHttpRequests().requestMatchers("/customers/addUser/**").permitAll()
				.and()
				.httpBasic()
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}
