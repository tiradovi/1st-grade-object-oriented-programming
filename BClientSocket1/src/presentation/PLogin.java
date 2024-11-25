package presentation;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin{
	
	public VUserInfo login(Scanner keyboard) {
		int maxAttempts = 5;
		int lockoutDuration = 30;
		int attempts = 0;
		System.out.println("로그인을 해주세요");
		

		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		if (choice == 1) {
			System.out.println("사용자 아이디 입력");
			String userId = keyboard.next();
			System.out.println("비밀번호 입력");
			String password = keyboard.next();

			VLogin vLogin = new VLogin();
			vLogin.setUserId(userId);
			vLogin.setPassword(password);

			CLogin cLogin = new CLogin();
			VUserInfo vUserInfo = cLogin.login(vLogin);

			if (vUserInfo == null) {
				attempts++;
				if (attempts >= maxAttempts) {
					System.out.println("비밀번호를 5회 이상 잘못 입력하여 " + lockoutDuration + "초간 입력이 금지됩니다.");
					try {
						TimeUnit.SECONDS.sleep(30);
						this.login(keyboard);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				} else {
					System.out.println("잘못 입력하셨습니다");
					this.login(keyboard);
				}
			} else {
				System.out.println(vUserInfo.getName() + "님 안녕하세요.");
			}

			return vUserInfo;

		} else if (choice == 2) {
			int minUserIdLength = 4;
			int maxUserIdLength = 8;
			int minPasswordLength = 3;
			int maxPasswordLength = 10;

			System.out.println("회원가입을 시작합니다.");
			System.out.println("생성할 사용자 아이디를 입력해주세요");
			System.out.println("아이디는 " + minUserIdLength + "자 이상, " + maxUserIdLength + "자 이하여야 합니다.");
			String userId = keyboard.next();
			System.out.println("생성할 비밀번호를 입력해주세요");
			System.out.println("비밀번호는 " + minPasswordLength + "자 이상, " + maxPasswordLength + "자 이하여야 합니다.");
			String password = keyboard.next();
			System.out.println("사용자의 이름을 입력해주세요");
			String name = keyboard.next();

			if (userId.length() < minUserIdLength || userId.length() > maxUserIdLength) {
				System.out.println("아이디가 " + minUserIdLength + "자 이상, " + maxUserIdLength + "자 이하가 아닙니다. 선택지로 돌아갑니다.");
				this.login(keyboard);
			}
			if (password.length() < minPasswordLength || password.length() > maxPasswordLength) {
				System.out.println(
						"비밀번호가 " + minPasswordLength + "자 이상, " + maxPasswordLength + "자 이하가 아닙니다. 선택지로 돌아갑니다.");
				this.login(keyboard);
			}

			VLogin vLogin = new VLogin();
			vLogin.setUserId(userId);
			vLogin.setPassword(password);

			CLogin cLogin = new CLogin();


			return null;
		}else if (choice == 3) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}else {
			System.out.println("정해진 숫자를 입력해주세요.");
			this.login(keyboard);
		}

		return null;
	}
}
