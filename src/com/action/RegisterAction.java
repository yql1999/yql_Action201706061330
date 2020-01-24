package com.action;

import com.bean.User;
import com.service.UserService;
import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// 方法一：模型封装
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	/*
	 * 方法二：表达式封装(但要在表单输入项的name属性值里面写表达式形式，如name="user.username")
	 * private User user;
	 * 
	 * public User getUser() { return user; }
	 * 
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	/*
	 * 接受用户的注册数据，在execute方法中对用户注册数据进行检验
	 * 
	 * 1）邮箱必须符合邮箱格式 2）用户名不得为空,且长度必须在8位以上，包含数字和字符 3）手机号码符合手机格式
	 */
	public String register() throws IOException {

		UserService userService = new UserService();

		if (userService.register(user) == 1) {
			this.addActionError("用户名或密码不能为空！");
			return "register";
		} else if (userService.register(user) == 2) {
			this.addActionError("用户名长度必须在8位以上，包含数字和字符！");
			return "register";
		} else if (userService.register(user) == 3) {
			this.addActionError("手机号不符合标准格式：号码位数必须为11位！");
			return "register";
		} else if (userService.register(user) == 0) {
			System.out.println("注册成功！");
			return "success";
		} else {
			this.addActionError("邮箱不符合邮箱格式，请重新填写！");
			return "register";
		}
	}

}
