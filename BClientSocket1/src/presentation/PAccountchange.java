package presentation;

import java.util.Scanner;

import model.MAccount;
import valueObject.VUserInfo;

public class PAccountchange {
	public void  PAccountchange (VUserInfo vUserInfo, Scanner keyboard) {
	System.out.println("����� ������ ����մϴ�. ������ �����Ϸ��� 1�� �����ּ���");
	System.out.println("�̸�: " + vUserInfo.getName());
	System.out.println("���̵�: " + vUserInfo.getUserId());
	System.out.println("��й�ȣ: " + vUserInfo.getPassword());
	String sCode = keyboard.next();
	int iCode = Integer.parseInt(sCode);
	if (iCode == 1) {
		System.out.println("������ �̸��� �ۼ����ּ���");
		String name = keyboard.next();
		System.out.println("������ ���̵� �ۼ����ּ���");
		String userId = keyboard.next();
		System.out.println("������ ��й�ȣ�� �ۼ����ּ���");
		String password = keyboard.next();

		vUserInfo.setName(name);
		vUserInfo.setUserId(userId);
		vUserInfo.setPassword(password);
		MAccount mAccount = new MAccount();

	}else {
		
	}
	}
}