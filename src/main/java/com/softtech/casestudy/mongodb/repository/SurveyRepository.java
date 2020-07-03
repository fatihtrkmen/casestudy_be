package com.softtech.casestudy.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtech.casestudy.mongodb.model.Survey;

public interface SurveyRepository extends MongoRepository<Survey, String> {
 List<Survey> findByQuestion(String question);
 List<Survey> findByCategoryContaining(String title);
}