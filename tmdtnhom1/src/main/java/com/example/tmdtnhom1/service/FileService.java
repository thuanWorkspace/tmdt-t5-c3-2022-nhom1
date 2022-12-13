package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User_file;
import com.example.tmdtnhom1.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserFileService userFileService;

    public List<File> getUserRootFile(String id_user) {
        return fileRepository.getUserRootFile(id_user);
    }

    public Optional<File> findById(String id_file) {
        return fileRepository.findById(id_file);
    }

	public File save(File file) {
		// TODO Auto-generated method stub
		return fileRepository.save(file);
	}

	public void deleteById(String id) {
		 fileRepository.deleteById(id);
	}

    public List<File> getListFileSearchByName(String name) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").regex(name));
//        List<File> users = mongoTemplate.find(query,File.class);
//        name = "[^"+name+"]";
        List<User_file> listpublic = userFileService.getPublicUserFile();
        List<File> listFileByName = fileRepository.getFileSearchByName(name);
        System.out.println("list file public");
        System.out.println(listFileByName);
        List<File> result = new ArrayList<>();
        for(File f : listFileByName){
            for (User_file uf : listpublic){
                if (f.getId().equals(uf.getId_file())){
                    result.add(f);
                    listpublic.remove(uf);
                }
            }
        }

        System.out.println(name);
        return result;
    }
}
