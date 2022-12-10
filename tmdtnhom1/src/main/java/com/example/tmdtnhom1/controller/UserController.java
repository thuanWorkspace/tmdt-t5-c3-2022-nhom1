package com.example.tmdtnhom1.controller;

import java.util.List;
import java.util.Optional;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.Login;
import com.example.tmdtnhom1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.service.UserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * members must identify parameters, output response in order to use.
 * @author MyPC
 *
 */


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	UserService userService;

	// hieu
	// login by email only.
	//api:  /login
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody Login login){
		try {
			User user = userService.checkLogin(login);
			if (user != null && (login.getPassword().equals(user.getPassword()))) {
				System.out.println(user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
			return new ResponseEntity("sai thong tin email hoac mat khau" ,HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
			System.out.println(list);
			
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
			return new ResponseEntity<String>("quan que 11111111111", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//phu
	//cap nhat thong tin nguoi dung
	@PostMapping("/user")
	public ResponseEntity<User> store(@RequestBody User user) {
		try {
			User _user = userService.save(new User(user.getUsername(),user.getEmail(),
					user.getPassword(),user.getRole(),user.getScore(),user.getDob(),user.getGender(),user.getData()));

			if(_user != null) {
				return new ResponseEntity<User>(_user, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") String id) {
		try {
			Optional<User> userData = userService.findById(id);

			if(userData.isPresent()) {
				User _user = userData.get();
				System.out.println(_user.toString());
//                _user.setEmail(user.getEmail());
				_user.setPassword(user.getPassword());
				_user.setUsername(user.getUsername());
//                _user.setRole(user.getRole());
//                _user.setScore(user.getScore());
				return new ResponseEntity<User>(userService.save(_user), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//phu
	// tu dong tich diem
	@PutMapping("/user/payment/{user_id}")
	public ResponseEntity<User> updateAfterPayment(@PathVariable("user_id") String user_id,
												   @RequestBody Product product){
		try{
			Optional<User> userData = userService.findById(user_id);

			if (userData.isPresent()){
				User user = userData.get();
				user.updateScore(product.getScore());
				return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//phu
	//order product
	@PutMapping("/user/payment/{user_id}/{score}")
	public ResponseEntity<User> updateAfterPayment(@PathVariable("user_id") String user_id,
												   @PathVariable Integer score){
		try{
			Optional<User> userData = userService.findById(user_id);

			if (userData.isPresent()){
				User user = userData.get();
				user.setScore(user.getScore() + score);
				return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
