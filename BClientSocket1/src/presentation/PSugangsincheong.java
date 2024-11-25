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
			System.out.println("메뉴를 선택하세요");
			System.out.println("강좌 검색 0, 미리담기 1, 수강신청 2, 책가방3, 사용자정보4, 종료 5");

			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			switch (iCode) {
			case 0:
				System.out.println("강좌를 검색합니다.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				break;
			case 1:
				System.out.println("미리담기합니다.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
				break;
			case 2:
				System.out.println("수강신청합니다.");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard, iCode);
				if (pSincheongBasket.isCreditLimitExceeded(18)) {
					System.out.println("추가 신청이 불가능합니다. credit 제한을 초과하였습니다.");

				} else {
					pSincheongBasket.add(vLecture);
					pSincheongBasket.show();

				}
				break;

			case 3:
				System.out.println("책가방을 선택해주세요.1.미리담기 가방 2.수강신청 가방");
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
				System.out.println("프로그램을 종료합니다.");
				bRunning = false;
				break;
			default:
				break;
			}
		}
	}
}