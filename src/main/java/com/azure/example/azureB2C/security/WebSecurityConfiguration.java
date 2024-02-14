package com.azure.example.azureB2C.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.azure.spring.cloud.autoconfigure.aadb2c.AadB2cOidcLoginConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

	private final AadB2cOidcLoginConfigurer configurer;

	public WebSecurityConfiguration(AadB2cOidcLoginConfigurer configurer) {
		this.configurer = configurer;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.apply(configurer).and().authorizeHttpRequests().anyRequest().authenticated();

		return http.build();
	}

}