package com.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.controller.RegisterValidator;
import com.interceptor.TestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class WebMvcConfig implements WebMvcConfigurer {
	
	// static files (html, css, js, etc)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// use jsp
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	// regist interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**").excludePathPatterns("/main");
    }
	
    // regist formatter
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter();
    }
    
    // 컨트롤러 구현 없이 컨트롤러 추가 (단순 페이지 이동이나 정적페이지 처리)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("index");
    	registry.addViewController("/main").setViewName("index");
    }
    
    @Bean
    public MessageSource messageSource() { // 반드시 messageSource() 로 지정하여야 작동한다
    	ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
    	rbms.setBasenames("message.label");
    	rbms.setDefaultEncoding("UTF-8");
    	return rbms;
    }
}
