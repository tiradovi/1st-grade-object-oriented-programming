package presentation;

import java.util.Scanner;

import model.MAccount;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {

	private PLectureSelection pLectureSelection;
	private PLectureBaskit pMiridamgiBasket;
	private PLectureBaskit pSincheongBasket;

	public PSugangsincheong() {

		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBaskit();
		this.pSincheongBasket = new PLectureBaskit();

	}

	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		while (bRunning) {
			System.out.println("�޴��� �����ϼ���");
			System.out.println("���� �˻� 0, �̸���� 1, ������û 2, å����3, ���������4, ���� 5");

			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			switch (iCode) {
			case 0:
				System.out.println("���¸� �˻��մϴ�.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				break;
			case 1:
				System.out.println("�̸�����մϴ�.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
				break;
			case 2:
				System.out.println("������û�մϴ�.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				if (pSincheongBasket.isCreditLimitExceeded(18)) {
					System.out.println("�߰� ��û�� �Ұ����մϴ�. credit ������ �ʰ��Ͽ����ϴ�.");

				} else {
					pSincheongBasket.add(vLecture);
					pSincheongBasket.show();

				}
				break;

			case 3:
				System.out.println("å������ �������ּ���.1.�̸���� ���� 2.������û ����");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				if (iCode == 1) {
					pMiridamgiBasket.PLectureBaskitrun(keyboard);
				}
				if (iCode == 2) {
					pSincheongBasket.PLectureBaskitrun(keyboard);
				}

				break;
			case 4:
				PAccountchange pAccountchange = new PAccountchange();
				pAccountchange.PAccountchange(vUserInfo, keyboard);
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				bRunning = false;
				break;
			default:
				break;
			}
		}
	}
}