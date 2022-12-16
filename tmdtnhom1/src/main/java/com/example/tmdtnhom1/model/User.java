package com.example.tmdtnhom1.model;

import com.example.tmdtnhom1.service.ProductService;
import com.example.tmdtnhom1.service.UserProductService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
public class User {
	@Id
	private String id;
	private String username;
	private String email;
	private String password;
	private int score;
	private String role;
	private String gender;
	private double data;

	public static final int score_factor = 10;//hệ số tỷ lệ giữa điểm và tiền
	public User() {
	}

	

	public User(String username, String email, String password, int score, String role, String gender) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
		this.role = role;
		this.gender = gender;
	}



	public String getId() {
		return id;
	}

	

	

	public User(String username, String email, String password, int score, String role, String gender, double data) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
		this.role = role;
		this.gender = gender;
		this.data = data;
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

	

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}


	public void updateScore(int score){
		this.score += score;
	}
	public void updateData(double data){this.data += data;}

	public int getValueScore(){
		return this.score * score_factor;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", score="
				+ score + ", role=" + role + ", gender=" + gender + "]";
	}


}
