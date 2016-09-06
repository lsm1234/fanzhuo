package com.web.dao;

import com.web.entity.User;

public interface UserDao {

	public User loadUserByName(String userName);
	
}
