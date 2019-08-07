package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class DefaultController {
	
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	@Value("#{servletContext.contextPath}")
	public String servletContextPath;
	
}