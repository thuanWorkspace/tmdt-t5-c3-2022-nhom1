package com.example.tmdtnhom1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Demo")
public class Demo {
	@Id
	private String id;
	private String username;
	private String title;
	private double money;
	public Demo(String id, String username, String title, double money) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Demo [id=" + id + ", username=" + username + ", title=" + title + ", money=" + money + "]";
	}

}
