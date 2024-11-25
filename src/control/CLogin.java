package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import Server.SMain;
import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {

	public VUserInfo login(VLogin vLogin) {
		
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.login(vLogin);
		return vUserInfo;}
		
	


public void createAccount(VLogin vLogin, String name) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Account/account", true));
        writer.write(vLogin.getUserId() + " " + vLogin.getPassword() + " " + name);
        writer.newLine();
        writer.close();
        System.out.println("아이디가 생성되었습니다. 선택지로 돌아갑니다.");
        SMain smain =new SMain();
		smain.run();
    } catch (IOException e) {
        System.out.println("오류 선택지로 돌아갑니다.");
        SMain smain =new SMain();
		smain.run();
        e.printStackTrace();
    }
}
}
