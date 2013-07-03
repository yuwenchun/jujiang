package com.lee.jiang.user;

import org.junit.Test;

import com.lee.core.test.AbstractTestCase;
import com.lee.jujiang.app.user.model.User;
import com.lee.jujiang.app.user.service.UserService;

public class UserServiceTest extends AbstractTestCase<UserService> {
	


	@Override
	public String[] getConfig() {
		
		 return new String[] { "spring-configs\\conf\\datasource-beans.xml", "spring-configs\\admin\\user-beans.xml" };

	}
	
	@Test
	public void testSave() throws Exception {
		
		User user = new User();
		user.setName("hello world");
		
		bean1.addUser(user);
	}

	@Override
	protected String getSessionFactoryId() {

		return "sessionFactory";
	}
	
	

}

