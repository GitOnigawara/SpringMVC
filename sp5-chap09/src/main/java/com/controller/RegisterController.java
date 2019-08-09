package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.MemberRegister;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@RequestMapping("/step1")
	public String getStep1() {
		return "register/step1";
	}
	
	@GetMapping("/step2")
	public String getStep2() {
		return "redirect:step1";
	}
	
	@PostMapping("/step2")
	public String setStep2(Model model, @RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if(!agree) return "redirect:step1";
		
		model.addAttribute("memberRegister", new MemberRegister());
		return "register/step2";
	}
	
	@GetMapping("/step3")
	public String getStep3() {
		return "redirect:step1";
	}
	
	@PostMapping("/step3")
	public String setStep3(@Valid MemberRegister memberRegister, Errors errors) {	
		if(errors.hasErrors()) {
			return "register/step2";
		} else {
			return "register/step3";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterValidator());
	}
	
}
