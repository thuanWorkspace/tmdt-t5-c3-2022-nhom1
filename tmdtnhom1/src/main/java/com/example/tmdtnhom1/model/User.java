package com.example.tmdtnhom1.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	@Id
	private String id;
//	private int id_user;
	private String username;
	private String email;
	private String password;
	private int score;
	private int role;
	private Date dob;
	private String gender;

	

	public User(String id, String username, String email, String password, int score, int role, Date dob,
			String gender) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
		this.role = role;
		this.dob = dob;
		this.gender = gender;
	}

	public Object getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
