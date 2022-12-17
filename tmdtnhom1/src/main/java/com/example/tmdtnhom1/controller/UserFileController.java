package com.example.tmdtnhom1.controller;

import com.example.tmdtnhom1.model.User_file;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.service.UserFileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	// thiếu body File
	@PostMapping("/upload")
    public ResponseEntity<User_file> uploadfile(@RequestBody User_file user_file) {
        try {
            User_file _file = userFileService.save(new User_file(user_file.getId_user(),user_file.getId_file()));

            if(_file != null) {
                return new ResponseEntity<User_file>(_file, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	// tien
	// api: /delete
    @DeleteMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deletefile(@PathVariable("id") String id) {
      try {
          userFileService.deleteById(id);
          return new ResponseEntity<>(HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
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
	// api: /showMyFiles
	public void showMyFiles() {
		
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

	//phu
	//quyen truy cap file

	//set public 1 file
	@PostMapping("/access/true")
	public ResponseEntity<User_file> store(@RequestBody User_file user_file) {
		try {

			List<User_file> list = userFileService.GetId(user_file.getId_user(), user_file.getId_file());
			switch (list.size()){
				case 0:
					User_file userFile = userFileService.save(new User_file(user_file.getId_user(),user_file.getId_file()));

					if(userFile != null) {
						return new ResponseEntity<User_file>(userFile, HttpStatus.CREATED);
					}
				case 1:
				{
					return new ResponseEntity<User_file>(list.get(0),HttpStatus.OK);
				}
				default: {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//set private 1 file
	@DeleteMapping("/access/false")
	public ResponseEntity<HttpStatus> delete(@RequestBody User_file userFile) {
		try {
			List<User_file> list = userFileService.GetId(userFile.getId_user(), userFile.getId_file());
			switch (list.size()){
				case 0:
					return new ResponseEntity<>(HttpStatus.OK);
				case 1:
				{
					String id = list.get(0).getId();
					userFileService.deleteById(id);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				default:
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}


		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// danh sach cac nguoi dung duoc chia se
	@GetMapping("/access/{file_id}")
	public ResponseEntity<List<User_file>> getUseraccessFile(@PathVariable("file_id") String file_id){
		try {
			List<User_file> list = new ArrayList<>();
			userFileService.getUseraccessFile(file_id).forEach(list::add);
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* $check$
	viết api lấy ra trạng thái hiện tại của file của user ( trạng thái private, public, hay share)
	-> chỉ 2 trạng thái public private, việc shared độc lập, lấy api "/access/{file_id}" get danh sách nguoi dung được chia sẻ
	Khi 1 file được tạo thì cũng tạo 1 userFile kèm theo mang iduser = idowner hoặc 0
	trước khi thực hiện api nhớ kt lại file đã có userFile hay chưa
	 */
	@GetMapping("/access/status/{owner_id}/{file_id}")
	public ResponseEntity<String> getStatusAccessOfFile(@PathVariable String file_id,@PathVariable String owner_id){
		try {

			User_file userFileData = userFileService.getAccessByIdFile(owner_id,file_id);
			String status = "public";

			if (userFileData.getId_user().equals(owner_id)){
				status = "private";
			}

			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/user_file/id")
	public ResponseEntity<String> update(@RequestBody User_file userFile){
		System.out.println(userFile.toString());
		List<User_file> list = userFileService.GetId(userFile.getId_user(), userFile.getId_file());
		if (list.size() != 1){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(list.get(0).getId(), HttpStatus.OK);
	}

	//thay doi quyen truy cap cua 1 user khac
	@PutMapping("/access/{id}/{hasaccess}")
	public ResponseEntity<User_file> ChangeAccessFile(@RequestBody User_file userFile,@RequestBody User owner
			, @PathVariable("id") String id, @PathVariable("hasaccess") boolean hasaccess){
		try{

			Optional<User_file> userFileData = userFileService.findById(id);

			if (userFileData.isPresent()){
				User_file user_file =  userFileData.get();
				user_file.setId_file(userFile.getId_file());
				user_file.setId_user(hasaccess?"0": owner.getId());
				return new ResponseEntity<User_file>(userFileService.save(user_file), HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public void shareFileTo(String idFile, String id_owner, String id_share) {
		
	}
	//danh sach cac file user duoc chia se
	@PutMapping("/useraccess/{user_id}/{hasaccess}")
	public ResponseEntity<User_file> ChangeUserAccessFile(@RequestBody User_file userFile
			, @PathVariable("hasaccess") boolean hasaccess,@PathVariable("user_id") String user_id){
		try{
			List<User_file> list = userFileService.GetId(userFile.getId_user(), userFile.getId_file());
			if (list.size() != 1){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String id = list.get(0).getId();
			Optional<User_file> userFileData = userFileService.findById(id);

			if (userFileData.isPresent()){
				User_file user_file =  userFileData.get();
				user_file.setId_file(userFile.getId_file());
				user_file.setId_user(hasaccess?"0":user_id);
				return new ResponseEntity<User_file>(userFileService.save(user_file), HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
