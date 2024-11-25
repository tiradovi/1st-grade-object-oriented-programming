package client;

import java.util.Scanner;

public class View {
	private CLogin cLogin;

	public View() {
		this.cLogin = new CLogin();
	}

	public void showUserInfo(Scanner keyboard) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("사용자 아이디 입력");
		String userId = scanner.next();
		System.out.println("비밀번호 입력");
		String password = scanner.next();

		String userInfo = this.cLogin.getUserInfo(keyboard,userId ,password);

	}
}
