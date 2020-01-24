package com.service;

import com.bean.User;

public class UserService {

	/*
	 * 1�����������������ʽ 2���û�������Ϊ��,�ҳ��ȱ�����8λ���ϣ��������ֺ��ַ� 3���ֻ���������ֻ���ʽ
	 */
	public int register(User user) {

		String username = user.getUsername();
		String phone = user.getPhone();
		String password = user.getPassword();
		String email = user.getEmail();

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("ʧ��1~");
			return 1;
		} else if (username.length() <= 8) {
			System.out.println("ʧ��2~");
			return 2;
		} else if (phone.length() != 11) {
			System.out.println("ʧ��3~");
			return 3;
		} else if (email.contains("@") && email.contains(".") && (email.lastIndexOf(".") > email.lastIndexOf("@"))) {
			return 0;
		}
		System.out.println("ʧ��4~");
		return 4;
	}

}
