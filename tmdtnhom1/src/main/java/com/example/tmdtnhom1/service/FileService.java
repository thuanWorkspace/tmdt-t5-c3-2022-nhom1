package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.Utils.IOUtils;
import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.UserType;
import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.model.User_file;
import com.example.tmdtnhom1.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService userService;

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

    //bo sung cap nhat data va het han goi
    //kt quyen truy cap,gioi han
    public File downloadFile(User user, File file) throws IndexOutOfBoundsException {
        UserType UserType = userService.getType(user);
        switch (UserType){
            case NORMAL:
                IOUtils.download(file,1000);
                break;
            case VIP:
                IOUtils.download(file,0);
                break;
            case STORAGE:
                if((user.getData() + file.getSize()) > userService.getLimitData(user)){
                    System.out.println((user.getData() + file.getSize() + " > " + userService.getLimitData(user)));
                    throw new IndexOutOfBoundsException();
                    //size total of user exceed benchmark
                }
                IOUtils.download(file,0);
                user.updateData(file.getSize());
                userService.save(user);
                break;
        }

        return file;
    }
    //size must bigger or equal not below.
    public void uploadFile(User user ,File file) throws IndexOutOfBoundsException {
        double totalFileEstimateUser = userService.getCurrentSizeStoraged(user) + file.getSize();
        //if size > 30GB free or > 100GB
        if(totalFileEstimateUser > userService.getLimitStorage(user)){
            throw new IndexOutOfBoundsException();
            //do dot upload
        }
        save(file);
    }
}
