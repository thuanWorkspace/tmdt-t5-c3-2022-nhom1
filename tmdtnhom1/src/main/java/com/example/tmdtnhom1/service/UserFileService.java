package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User_file;
import com.example.tmdtnhom1.repository.User_fileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFileService {
	@Autowired
	User_fileRepository user_fileRepository;

	public void downloadPublicFile() {
		/**
		 * if( user buy product VIP,and VIP still has available) download fast else if(
		 * user buy product 'capacity product') download fast
		 * 
		 */
	}

	//phu
	//quyen truy cap file
	public List<User_file> GetId(String id_user, String id_file) {
		return user_fileRepository.getId(id_user,id_file);
	}

	public User_file save(User_file user_file) {
		return user_fileRepository.save(user_file);
	}

	public void deleteById(String id) {
		user_fileRepository.deleteById(id);
	}

	public List<User_file> getUseraccessFile(String file_id) {
		return user_fileRepository.getUseraccessFile(file_id);
	}

	public Optional<User_file> findById(String id) {
		return user_fileRepository.findById(id);
	}

	public List<User_file> getUserSharedFile(String user_id) {
		return user_fileRepository.getUserSharedFile(user_id);
	}

	List<User_file> getPublicUserFile(){
		return user_fileRepository.getUserSharedFile("0");
	}
}
