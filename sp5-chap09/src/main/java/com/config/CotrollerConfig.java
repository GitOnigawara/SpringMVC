 package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.controller.HelloController;
import com.controller.RegisterController;
import com.controller.SurveyController;

@Configuration
public class CotrollerConfig {
	
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}
	
}
