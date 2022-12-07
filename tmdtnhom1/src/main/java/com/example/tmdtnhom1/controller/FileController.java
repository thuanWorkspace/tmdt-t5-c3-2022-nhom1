package com.example.tmdtnhom1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User_file;
import com.example.tmdtnhom1.service.FileService;
import com.example.tmdtnhom1.service.UserFileService;

@RestController
@RequestMapping("/fileapi")
public class FileController {
    //phu

    @Autowired
    FileService fileService;

    @Autowired
    UserFileService userFileService;
    /**
     * get all files in id user.
     * @param id_user
     * @return
     * @author phu
     */
    @GetMapping("/file/FileManager/{id_user}")
    public ResponseEntity<List<File>> getAll(@PathVariable("id_user") String id_user){
        try{
            System.out.println("in api "+id_user);
            List<File> list = new ArrayList<>();
            fileService.getUserRootFile(id_user).forEach(list::add);
            System.out.println(id_user + list.size());
            if (list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * get specific file by id of file. not user relate.
     * @purpose check
     * @param id_user
     * @return
     * @author phu
     */
    @GetMapping("/file/{id}")
    public ResponseEntity<File> getById(@PathVariable("id") String id_file){
        try{
            Optional<File> fileData = fileService.findById(id_file);

            if (fileData.isPresent()){
                File file = fileData.get();
                return new ResponseEntity<File>(file,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/file/Fileaccess/{user_id}")
    public ResponseEntity<List<File>> getUserSharedFile(@PathVariable("user_id") String user_id){
        try{
            List<User_file> list = new ArrayList<>();
            userFileService.getUserSharedFile(user_id).forEach(list::add);

            List<File> result = new ArrayList<>();

            for (User_file u : list){
                Optional<File> fileData = fileService.findById(u.getId_file());
                if (fileData.isPresent()){
                    File file = fileData.get();
                    System.out.println(file.getOwner() + " kt "+ u.getId_user());
                    if (!file.getOwner().equals(u.getId_user())){
                        result.add(file);
                    }
                }

            }

            if (list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//
//    @PutMapping("/file/{id}")
//    public ResponseEntity<File> update(@RequestBody File file, @PathVariable("id") String id) {
//        try {
//            Optional<File> fileData = fileRepository.findById(id);
//
//            if(fileData.isPresent()) {
//                File _file = fileData.get();
//              _file.setFile_name(file.getFile_name());
//              _file.setOwner(file.getOwner());
//              _file.setSize(file.getSize());
//              _file.setUrl(file.getUrl());
//              _file.setRole(file.getRole());
//              _file.setParentFile(file.getParentFile());
//                return new ResponseEntity<File>(fileRepository.save(_file), HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    
    
    //Tien
    //upload file
    @PostMapping("/file/upload/{id_user}")
    public ResponseEntity<File> upload(@RequestBody File file,@PathVariable("id_user") String id_user){
    	try {
    		return new ResponseEntity<File>(fileService.save(new File(file.getFile_name(), id_user, file.getSize())), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @DeleteMapping("/file/delete/{id_user}")
    public ResponseEntity<HttpStatus> deletefile(@PathVariable("id") String id) {
        try {
            fileService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}