package com.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.command.register.MemberRegister;

public class RegisterValidator implements Validator {
	
	private static final String emailRegExp = "[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,}";
	private Pattern pattern;
	
	public RegisterValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> cls) {
		return MemberRegister.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		MemberRegister memberRegister = (MemberRegister) target;
		
		if(memberRegister.getEmail() == null || memberRegister.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(memberRegister.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		
		if(!memberRegister.getPassword().isEmpty()) {
			if(!memberRegister.isPasswordEqual()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}

}
