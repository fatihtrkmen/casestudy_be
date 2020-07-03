package com.softtech.casestudy.mongodb.model;

import java.util.ArrayList;

public class QuestionType {
private String type;
private ArrayList<String> options;
public ArrayList<String> getOptions() {
	return options;
}
public void setOptions(ArrayList<String> options) {
	this.options = options;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}
