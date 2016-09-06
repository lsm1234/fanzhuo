package com.web.model.impl;

import java.util.List;

import com.web.controller.Menu;
import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.entity.User;
import com.web.model.UserModel;

public class UserModelMySQLImpl implements UserModel{
	//模型层将有一个DAO层对象
	private UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public User loadUserByName(String userName) {
		System.out.println("UserModelMySQLImpl模型层");
		return userDao.loadUserByName(userName);		
	}
	

	@Override
	public List<Menu> loadMenusByUid(Object eid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
