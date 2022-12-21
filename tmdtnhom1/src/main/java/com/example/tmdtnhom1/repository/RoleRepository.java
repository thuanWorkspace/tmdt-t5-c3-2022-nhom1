package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
