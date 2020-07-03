package com.softtech.casestudy.mongodb.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtech.casestudy.mongodb.model.Status;
public interface StatusRepository extends MongoRepository<Status, String> {

}