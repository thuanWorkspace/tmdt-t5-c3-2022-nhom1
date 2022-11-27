package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FileRepository extends MongoRepository<File,String> {
    @Query("{'owner' :  ?0,'parentFile': 'root'}")
    public List<File> getUserRootFile(String owner);


}
