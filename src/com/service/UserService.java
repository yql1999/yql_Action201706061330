package com.service;

import com.bean.User;

public class UserService {

	/*
	 * 1）邮箱必须符合邮箱格式 2）用户名不得为空,且长度必须在8位以上，包含数字和字符 3）手机号码符合手机格式
	 */
	public int register(User user) {

		String username = user.getUsername();
		String phone = user.getPhone();
		String password = user.getPassword();
		String email = user.getEmail();

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("失败1~");
			return 1;
		} else if (username.length() <= 8) {
			System.out.println("失败2~");
			return 2;
		} else if (phone.length() != 11) {
			System.out.println("失败3~");
			return 3;
		} else if (email.contains("@") && email.contains(".") && (email.lastIndexOf(".") > email.lastIndexOf("@"))) {
			return 0;
		}
		System.out.println("失败4~");
		return 4;
	}

}
