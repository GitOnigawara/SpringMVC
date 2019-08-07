package com.command.survey;

import java.util.Collections;
import java.util.List;

public class Question {

	private String title;
	private List<String> options;
	
	public Question() {}
	
	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}
	
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public List<String> getOptions() {
		return this.options;
	}

	public boolean isChoice() { // call choice
		return options != null && !options.isEmpty();
	}
	
}
