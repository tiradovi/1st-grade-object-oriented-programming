package presentation;

import java.util.Scanner;


import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {

	public VUserInfo login(Scanner keyboard, String userId, String password) {

		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);

		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);

		return vUserInfo;

	}
}
