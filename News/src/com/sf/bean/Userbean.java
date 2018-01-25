package com.sf.bean;

public class Userbean {
	private int id;
	private String name;
	private String password;
	private String userClass;
	private String imgaddress;
	private String email;
	
	public String getImgaddress() {
		return imgaddress;
	}
	public void setImgaddress(String imgaddress) {
		this.imgaddress = imgaddress;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
