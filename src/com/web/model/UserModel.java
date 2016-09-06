package com.web.model;

import java.util.List;

import com.web.controller.Menu;
import com.web.entity.User;

public interface UserModel {
	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName用户输入的账号
	 * @return返回null表示用户的账号不存在
	 */
	public User loadUserByName(String userName);

	public List<Menu> loadMenusByUid(Object eid);

}
