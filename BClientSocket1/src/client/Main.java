package client;

import java.util.Scanner;

import presentation.PLogin;
import valueObject.VUserInfo;

public class Main {

	private Scanner keyboard;
	private client.PLogin pLogin;

	public void run() {
		keyboard = new Scanner(System.in);
		pLogin = new client.PLogin();
		pLogin.login(keyboard);


	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}
