package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.web.dao.UserDao;
import com.web.entity.User;
import com.web.util.DBUtil;



public class UserDaoImpl implements UserDao{
	public User loadUserByName(String userName){
		
		System.out.println("UserDaoImpl数据层");
		String sql ="select * from tb_user where number=?";
		List<Object[]> list = DBUtil.DQL(sql,new Object[]{ userName });
		User user = null;
		if(null != list && list.size()>0){
			Object[]os=list.get(0);
			user = new User((String)os[1],(String)os[2],(String)os[3]);
					
		}
		return user;
	}
	public List<User> loadAllUser(){
	System.out.println("UserDaoImpl数据层");
	String sql ="select * from tb_user where userName=?";
	List<Object[]> list = DBUtil.DQL(sql,null);
	User user = null;
	List<User> listl=new ArrayList<User>();
	for(Object[] os: list){
		user = user = new User((String)os[1],(String)os[2],(String)os[3]);
		listl.add(user);
	}
	return listl;		
	}
}
