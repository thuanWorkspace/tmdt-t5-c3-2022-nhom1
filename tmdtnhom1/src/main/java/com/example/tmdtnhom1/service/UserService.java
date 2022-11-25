package com.example.tmdtnhom1.service;

import java.util.List;

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
	public void login(String email,String password) {
		
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
}
