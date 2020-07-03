package com.softtech.casestudy.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="answer")
public class Answer {
	@Id
	private String id;
	private String question_id;
	private String answer;
	private String category;
	
	public Answer() {
		
	}

	public Answer(String question_id, String answer) {
		this.question_id = question_id;
	    this.answer = answer;
	 }
	
	private String getId() {
		return id;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
