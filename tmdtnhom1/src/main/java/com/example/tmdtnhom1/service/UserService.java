package com.example.tmdtnhom1.service;

import java.util.List;
import java.util.Optional;

import com.example.tmdtnhom1.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	//admin
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	//user
	//login by email only.
	public User checkLogin(Login login) {
		User user = userRepository.findByEmail(login.getEmail());
		return user;
	}

	public void register() {
		
	}
	public void googleLogin() {
		
	}
	public void facebookLogin() {
		
	}
	public void logOut() {
		
	}
	//forgot password
	public void resetPassword() {
		
	}
	public void changePassword() {
		
	}

	//phu
	//update userInfo
	public User save(User user){
		return userRepository.save(user);
	}

	public Optional<User> findById(String id) {
		return  userRepository.findById(id);
	}
}
