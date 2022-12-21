package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.File;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FileRepository extends MongoRepository<File,String> {
    @Query("{'owner' :  ?0}")
    public List<File> getUserRootFile(String owner);

    @Query("{'file_name' : ?0}")// { $in : ?0}
//    @Aggregation(pipeline = {"{'$match ':{'file_name': ?0}}"})
    public List<File> getFileSearchByName(String file_name);
}
