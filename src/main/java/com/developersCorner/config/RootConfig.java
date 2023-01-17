package com.developersCorner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.developersCorner.exception.ApiExceptionHandler;

@ComponentScan(basePackages = {
		"com.developersCorner.service",
		"com.developersCorner.config",
		"com.developersCorner.security"
})
public class RootConfig {

	@Bean
	ApiExceptionHandler apiExceptionHandler() {
		return new ApiExceptionHandler();
	}
}
