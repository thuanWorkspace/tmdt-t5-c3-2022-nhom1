package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.UserProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserProductRepository extends MongoRepository<UserProduct,String> {
    @Query("{'id_user' :  ?0}")
    List<UserProduct> getUserProductByUser(String id_user);
}
