package com.softtech.casestudy.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtech.casestudy.mongodb.model.Answer;

public interface AnswerRepository extends MongoRepository<Answer, String> {
}
