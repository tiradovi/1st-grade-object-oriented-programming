package client;

import java.util.Scanner;

import valueObject.VUserInfo;

public class PLogin {

	public VUserInfo login(Scanner keyboard) {

		System.out.println("로그인을 해주세요");

		View view;
		view = new View();
		view.showUserInfo(keyboard);
		return null;

	}
}
