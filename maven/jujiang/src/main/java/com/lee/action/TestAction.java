package com.lee.action;

import com.lee.bean.InjectedUtil;
import com.lee.jujiang.app.user.service.UserService;
import com.lee.jujiang.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	// @Inject
	private InjectedUtil util;

	private String name;

	private UserService service;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {

		if (util != null) {
			System.out.println(util.doAny());
		}

		User user = new User();
		user.setName("hello world");

		try {
			service.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InjectedUtil getUtil() {
		return util;
	}

	public void setUtil(InjectedUtil util) {
		this.util = util;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}
