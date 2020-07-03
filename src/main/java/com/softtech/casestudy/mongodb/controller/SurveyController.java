package com.softtech.casestudy.mongodb.controller;


import com.softtech.casestudy.mongodb.model.Answer;
import com.softtech.casestudy.mongodb.model.Status;
import com.softtech.casestudy.mongodb.model.Survey;
import com.softtech.casestudy.mongodb.repository.AnswerRepository;
import com.softtech.casestudy.mongodb.repository.StatusRepository;
import com.softtech.casestudy.mongodb.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SurveyController {

 @Autowired
 SurveyRepository surveyRepository;

 @Autowired
 AnswerRepository answerRepository;
 
 @Autowired
 StatusRepository statusRepository;
 
 
 
 @GetMapping("/surveys")
 public ResponseEntity<List<Survey>> getAllSurveys(@RequestParam(required = false) String category) {
   try {
     List<Survey> surveys = new ArrayList<Survey>();

     if (category == null)
    	 surveyRepository.findAll().forEach(surveys::add);
     else
    	 surveyRepository.findByCategoryContaining(category).forEach(surveys::add);

     if (surveys.isEmpty()) {
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     return new ResponseEntity<>(surveys, HttpStatus.OK);
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }
 }
 
 @GetMapping("/getStatus")
 public ResponseEntity<List<Status>> getStatus() {
	 List<Status> _status = new ArrayList<Status>();
   try {
	   
  	 statusRepository.findAll().forEach(_status::add);
  	 
     return new ResponseEntity<>(_status,HttpStatus.OK);
   
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
   }
 }
 
 @GetMapping("/saveStatus")
 public ResponseEntity<Status> saveStatus(@RequestParam String categoryName) {
   try {
	   
	   Status _status = statusRepository.save(new Status(categoryName));
  	 
     return new ResponseEntity<>(_status,HttpStatus.OK);
   
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
   }
 }

 @PostMapping("/saveAnswers")
 public ResponseEntity<Answer> saveSurvey(@RequestBody List<Answer> answers) {
   try {
	   Object s = answerRepository.saveAll(answers);
     return new ResponseEntity<>((Answer)s, HttpStatus.CREATED);
   } catch (Exception e) {
     return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
   }
 }
 
 @GetMapping("/getMyAnswers")
 public ResponseEntity<List<Answer>> getMyAnswers() {
	   try {
		     List<Answer> myAnswers = new ArrayList<Answer>();

		     answerRepository.findAll().forEach(myAnswers::add);

		     return new ResponseEntity<>(myAnswers, HttpStatus.OK);
		   } catch (Exception e) {
		     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		   }
 }
}