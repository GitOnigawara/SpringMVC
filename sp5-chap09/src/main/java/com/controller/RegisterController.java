package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.command.register.MemberRegister;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@RequestMapping("/step1")
	public String getStep1() {
		return "register/step1";
	}
	
	@GetMapping("/step2")
	public String getStep2() {
		return "redirect:register/step1";
	}
	
	@PostMapping("/step2")
	public String setStep2(Model model, @RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if(!agree) return "register/step1";
		
		model.addAttribute("memberRegister", new MemberRegister());
		return "register/step2";
	}
	
	@GetMapping("/step3")
	public String getStep3() {
		return "redirect:register/step1";
	}
	
	@PostMapping("/step3")
	public String setStep3(@ModelAttribute("memberRegister") MemberRegister memberRegister, Errors errors) {
		
		return "register/step3";
	}
	
}
