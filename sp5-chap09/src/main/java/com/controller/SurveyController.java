package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.command.survey.Answer;
import com.command.survey.Question;

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
		Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("server developer", "front end developer", "back end developer", "full stack developer"));
		Question q2 = new Question("선호하는 IDE는 무엇입니까?", Arrays.asList("Eclipse", "IntelliJ", "SublimeText", "Visual Studio Code"));
		Question q3 = new Question("앞으로 하고 싶은것은 무엇입니까?");
		return Arrays.asList(q1, q2, q3);
	}
	
}
