package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User_file;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface User_fileRepository extends MongoRepository<User_file,String> {

    //phu
    @Query("{'id_user' : :#{#id_user}, 'id_file' : :#{#id_file}}")
    public List<User_file> getId(@Param("id_user") String id_user,@Param("id_file") String id_file);

    @Query("{'id_user': ?0}")
    List<User_file> getUserSharedFile(String id_user);


    @Query("{'id_file': ?0}")
    List<User_file> findByIdFile(String file_id);
}
