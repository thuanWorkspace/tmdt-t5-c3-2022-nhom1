package com.example.tmdtnhom1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.service.UserFileService;
import com.example.tmdtnhom1.service.UserProductService;

/**
 * members must identify parameters, output response in order to use.
 * 
 * @author MyPC
 *
 */
@RestController
@RequestMapping("/userfileapi")
public class UserFileController {
	@Autowired
	UserFileService userFileService;

	// tien
	// api: /upload
	public void uploadfile() {
	}

	// tien
	// api: /delete
	public void deletefile() {

	}

	// tien
	// api: /searchpublicfile
	public void searchPublicFile() {
	
	}

	// tien
	// api: /changerole
	public void changeRoleFile() {

	}

	// tien
	// api: /downloadpublicfile
	public void downloadPublicFile() {
		userFileService.downloadPublicFile();
	}

	// tien
	// api: /sharefile
	// owner shares file to user
	public void FileShareToUser(User owner, File file, User user) {

	}

	// tien
	// api: /createfolder
	public void createFolder() {

	}
}
