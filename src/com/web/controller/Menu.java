package com.web.controller;

import java.io.Serializable;

public class Menu implements Serializable{
	private String name;
	
	private String url;
	
	private int isshow;
	
	private int level;
	
	private int parentid;
	
	public Menu() {
		super();
	}

	public Menu(String name, String url, int isshow, int level, int parentid) {
		super();
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
	

}
