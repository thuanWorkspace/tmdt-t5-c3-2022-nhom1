package com.example.tmdtnhom1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tmdtnhom1.model.User;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String>{

    @Query("{'email' : ?0}")
    public User findByEmail(String email);


}
