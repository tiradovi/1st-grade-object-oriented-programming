package presentation;

import java.util.Scanner;

import model.MAccount;
import valueObject.VUserInfo;

public class PAccountchange {
	public void  PAccountchange (VUserInfo vUserInfo, Scanner keyboard) {
	System.out.println("사용자 정보를 출력합니다. 파일을 변경하려면 1을 눌러주세요");
	System.out.println("이름: " + vUserInfo.getName());
	System.out.println("아이디: " + vUserInfo.getUserId());
	System.out.println("비밀번호: " + vUserInfo.getPassword());
	String sCode = keyboard.next();
	int iCode = Integer.parseInt(sCode);
	if (iCode == 1) {
		System.out.println("변경할 이름을 작성해주세요");
		String name = keyboard.next();
		System.out.println("변경할 아이디를 작성해주세요");
		String userId = keyboard.next();
		System.out.println("변경할 비밀번호를 작성해주세요");
		String password = keyboard.next();

		vUserInfo.setName(name);
		vUserInfo.setUserId(userId);
		vUserInfo.setPassword(password);
		MAccount mAccount = new MAccount();

	}else {
		
	}
	}
}