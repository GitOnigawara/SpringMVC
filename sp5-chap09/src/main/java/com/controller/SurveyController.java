package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Answer;
import com.model.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping
	public String getSurvey(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);
		
		return "survey/form";
	}
	
	@PostMapping
	public String setSurvey(@ModelAttribute("answer") Answer data) {
		return "survey/result";
	}
	
	private List<Question> createQuestions() {
		Question q1 = new Question("what your roll?", Arrays.asList("server", "front-end", "back-end", "full stack"));
		Question q2 = new Question("favorite IDE?", Arrays.asList("Eclipse", "IntelliJ", "SublimeText", "Visual Studio Code"));
		Question q3 = new Question("say somthing please");
		return Arrays.asList(q1, q2, q3);
	}
	
}
