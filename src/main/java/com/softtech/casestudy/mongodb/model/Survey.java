package com.softtech.casestudy.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="surveys")
public class Survey {
@Id
private String id;

private String question;
private String category;
private QuestionType question_type;

public Survey() {
	
}

public Survey(String question, String category) {
    this.question = question;
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

public QuestionType getQuestion_type() {
	return question_type;
}

public void setQuestion_type(QuestionType question_type) {
	this.question_type = question_type;
}
  
}

