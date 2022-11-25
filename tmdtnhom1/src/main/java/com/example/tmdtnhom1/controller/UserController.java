package com.example.tmdtnhom1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.service.UserService;
/**
 * members must identify parameters, output response in order to use.
 * @author MyPC
 *
 */
@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	UserService userService;

	// hieu
	// login by email only.
	//api:  /login
	public void login(String email, String password) {

	}
	// hieu
	// api: /register
	public void register() {

	}
	// hieu
	//api: /googleLogin
	public void googleLogin() {

	}
	// hieu
	//api: /facebookLogin
	public void facebookLogin() {

	}
	// hieu
	//api: /logOut
	public void logOut() {

	}
	// hieu
	// forgot password
	//api: /resetPassword
	public void resetPassword() {

	}
	// hieu
	//api: /changePassword
	public void changePassword() {

	}
	// hieu
	//api: /user
	public void getUser() {
		
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> list = userService.getAllUsers();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// check running
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		try {
			return new ResponseEntity<String>("hello world", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}