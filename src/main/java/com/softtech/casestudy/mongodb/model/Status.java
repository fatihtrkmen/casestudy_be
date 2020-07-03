package com.softtech.casestudy.mongodb.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="status")
public class Status {

@Id
private String id;
private String categoryName;
private Boolean status;

public Status(String categoryName) {
this.setCategoryName(categoryName);
this.setStatus(true);
 }



public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}

private String getId() {
	return id;
}



public String getCategoryName() {
	return categoryName;
}



public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

}
