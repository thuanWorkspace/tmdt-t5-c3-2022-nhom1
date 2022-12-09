package com.example.tmdtnhom1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tmdtnhom1.model.Demo;
import com.example.tmdtnhom1.model.User;

public interface DemoRepository extends MongoRepository<Demo, String>{

}
