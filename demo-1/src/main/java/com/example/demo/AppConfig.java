package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public String greeting() {
		return "Hello, World";
		
	}
	
	@Bean 
	public String book() {
		return "Oliver Twist";
	}
	}



