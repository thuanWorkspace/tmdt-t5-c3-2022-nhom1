package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;


    public List<File> getUserRootFile(String id_user) {
        return fileRepository.getUserRootFile(id_user);
    }

    public Optional<File> findById(String id_file) {
        return fileRepository.findById(id_file);
    }

}
