package com.lee.jujiang.auth.user.service.impl;

import com.lee.jujiang.auth.user.dao.UserDao;
import com.lee.jujiang.auth.user.model.User;
import com.lee.jujiang.auth.user.service.UserService;

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
