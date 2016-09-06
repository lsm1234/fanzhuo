package com.web.util;

import java.io.Serializable;

public class MenuVO implements Serializable{
	private int mid;
	private String name;
	private String url;
	private int isshow = 1;
	private int level;
	private String parentName;
	public String toString(){
		return"{\"mid\":"+mid+",\"name\":"+name+",\"url\":"+url+",\"isshow\":"+isshow+",\"level\":"+level+",\"parentName\":"+parentName+"}";
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	

}
