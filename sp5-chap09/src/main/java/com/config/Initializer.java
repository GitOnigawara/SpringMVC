package com.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// set profiles
		// servletContext.setInitParameter("spring.profiles.active", "real"); 
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setServletContext(servletContext);
		context.setConfigLocation("com.config");
		context.refresh();
		
		// dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		// character encoding filter
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");	
		
		/* addMappingForUrlPatterns(dispatcherTypes, isMatchAfter, urlPatterns);
		 * dispatcherTypes	: 어떤 요청에 맵핑할지 결정 (REQUEST, RESPONSE 등) null 입력시 DispatcherType.REQUEST 
		 * isMatchAfter		: 미리 선언된 필터 매핑 이전 / 이후에 매핑할지 결정
		 * 					  true	- 주어진 필터 매핑이 선언된 필터 매핑 이후에 매칭될때
		 *					  false	- (FilterRegistration의 범위 아래) 선언된 ServletContext의 필터 매핑보다 이전에 매칭이 되어야 할때
		 * urlPatterns		: URL 패턴
		 */
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}
}