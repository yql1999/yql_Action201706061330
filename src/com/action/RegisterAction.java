package com.action;

import com.bean.User;
import com.service.UserService;
import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// ����һ��ģ�ͷ�װ
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	/*
	 * �����������ʽ��װ(��Ҫ�ڱ��������name����ֵ����д���ʽ��ʽ����name="user.username")
	 * private User user;
	 * 
	 * public User getUser() { return user; }
	 * 
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	/*
	 * �����û���ע�����ݣ���execute�����ж��û�ע�����ݽ��м���
	 * 
	 * 1�����������������ʽ 2���û�������Ϊ��,�ҳ��ȱ�����8λ���ϣ��������ֺ��ַ� 3���ֻ���������ֻ���ʽ
	 */
	public String register() throws IOException {

		UserService userService = new UserService();

		if (userService.register(user) == 1) {
			this.addActionError("�û��������벻��Ϊ�գ�");
			return "register";
		} else if (userService.register(user) == 2) {
			this.addActionError("�û������ȱ�����8λ���ϣ��������ֺ��ַ���");
			return "register";
		} else if (userService.register(user) == 3) {
			this.addActionError("�ֻ��Ų����ϱ�׼��ʽ������λ������Ϊ11λ��");
			return "register";
		} else if (userService.register(user) == 0) {
			System.out.println("ע��ɹ���");
			return "success";
		} else {
			this.addActionError("���䲻���������ʽ����������д��");
			return "register";
		}
	}

}
