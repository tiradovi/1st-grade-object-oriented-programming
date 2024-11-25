package client;

import java.util.Scanner;

import client.Stub;

public class CLogin extends Stub {

	public CLogin() {
		super("localhost", 12345);

	}

	public String getUserInfo(Scanner keyboard, String userId, String password) {

		String result = this.request("SMain", "run2", " ", userId, password);

		return result;
	}

	public String getUserInfo1(Scanner keyboard, String userId, String password) {

		String result = this.request("SMain", "run3", " ", userId, password);

		return result;
	}

}
