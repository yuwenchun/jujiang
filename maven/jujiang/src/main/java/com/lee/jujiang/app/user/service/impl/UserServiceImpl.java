package com.lee.jujiang.app.user.service.impl;

import com.lee.jujiang.app.user.dao.UserDao;
import com.lee.jujiang.app.user.service.UserService;
import com.lee.jujiang.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDao dao;

	@Override
	public void addUser(User user) throws Exception {
		
		dao.save(user);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
}
