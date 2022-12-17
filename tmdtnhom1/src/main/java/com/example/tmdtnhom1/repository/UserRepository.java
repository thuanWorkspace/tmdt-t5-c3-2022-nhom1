package com.example.tmdtnhom1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tmdtnhom1.model.User;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>{

    @Query("{'email' :  ?0}")
    List<User> findByEmail(String email);
}
