package Server;

import java.util.Scanner;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class SMain {
	private Skeleton skeleton;
	private Scanner keyboard;
	private PLogin pLogin;

	public void run() {
		this.skeleton = new Skeleton();
		this.skeleton.process();
	}

	public String run2(String userId, String password) {
		keyboard = new Scanner(System.in);
		pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(keyboard, userId, password);
		 String welcomeMessage = vUserInfo.getName() + "님 환영합니다.";

		return welcomeMessage ; 
	}

	public void run3(String userId, String password) {
		VUserInfo vUserInfo = new VUserInfo();
		PSugangsincheong pSugangsincheong = new PSugangsincheong();
		pSugangsincheong.run(vUserInfo, keyboard);

	}

	public static void main(String[] args) {
		SMain main = new SMain();
		main.run();

	}

}
