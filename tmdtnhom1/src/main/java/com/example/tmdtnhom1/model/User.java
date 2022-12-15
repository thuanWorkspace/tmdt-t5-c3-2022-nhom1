package com.example.tmdtnhom1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.tmdtnhom1.Utils.DateUtils;
import com.example.tmdtnhom1.service.ProductService;
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
//	private String dob;
	private String gender;
	private long data;
	private List<UserProduct> servicepacks = new ArrayList<>();

	public static final int score_factor = 10;//hệ số tỷ lệ giữa điểm và tiền
	public User() {
	}

	public User(String username, String email, String password, int score, int role, String gender, long data) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
		this.role = role;
//		this.dob = DateUtils.DatetoString(dob);
		this.gender = gender;
		this.data = data;
	}

	public User(String id, String username, String email, String password, int score, int role,
				String gender, long data) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
		this.role = role;
//		this.dob = DateUtils.DatetoString(dob);
		this.gender = gender;
		this.data = data;
	}

	public String getId() {
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

//	public Date getDob() {
//		return DateUtils.StringtoDate(dob);
//	}
//
//	public void setDob(Date dob) {
//		this.dob = DateUtils.DatetoString(dob);
//	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public List<UserProduct> getServicepacks() {
		return servicepacks;
	}

	public void setServicepacks(List<UserProduct> servicepacks) {
		this.servicepacks = servicepacks;
	}

	public void updateScore(int score){
		this.score += score;
	}

	public long getLimitData(){
		long limitdata = 0;
		for (UserProduct sp : servicepacks){
			ProductService productService = new ProductService();
			Product product = productService.getById(sp.getId_product()).get();
			limitdata += product.getTransfer();
		}
		return limitdata;
	}

	public int getValueScore(){
		return this.score * score_factor;
	}
}
