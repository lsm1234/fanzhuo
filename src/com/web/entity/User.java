package com.web.entity;

public class User {
	private String uid;
	
	private String number;
	
	private String password;
	
	

	public User(String uid, String number, String password) {
		super();
		this.uid = uid;
		this.number = number;
		this.password = password;
	}
	

	public User() {}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	
	}
	
	


