package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection {
	private CIndex cIndex;
	private CLecture cLecture;

	private PLectureBaskit pMiridamgiBasket;
	private PLectureBaskit pSincheongBasket;

	public PLectureSelection() {

		// add child components
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
		this.pMiridamgiBasket = new PLectureBaskit();
		this.pSincheongBasket = new PLectureBaskit();
	}

	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + " 코드 입력");

		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for (VIndex vIndex : vIndexVector) {
			vIndex.show();

		}

		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		int again = 1;
		while (again == 1) {

			for (VIndex vIndex : vIndexVector) {

				if (vIndex.getCode() == iCode) {
					again = 0;
					break;
				}
				selectedIndex++;
			}

			if (again == 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				selectedIndex = 0;
			}
		}

		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();

		return selectedFileName;
	}

	private VLecture findLecture(String message, String fileName, Scanner keyboard) {

		System.out.println(message + " 코드 입력");

		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for (VLecture vLecture : vLectureVector) {
			vLecture.show();
		}
		int selectedIndex = 0;
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);

		int again = 1;
		while (again == 1) {

			for (VLecture vLecture : vLectureVector) {

				if (vLecture.getCode() == iCode) {
					again = 0;
					break;
				}
				selectedIndex++;
			}

			if (again == 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				selectedIndex = 0;
			}
		}
		VLecture vLecture = vLectureVector.get(selectedIndex);
		return vLecture;
	}

	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard, int iCode) {
		String campusFileName = this.findIndex("캠퍼스", "root", keyboard);
		String collegeFileName = this.findIndex("대학", campusFileName, keyboard);
		String departmentFileName = this.findIndex("학과", collegeFileName, keyboard);
		VLecture vLecture = this.findLecture("강좌", departmentFileName, keyboard);

		if (iCode == 0) {
			System.out.println("강좌를 미리담기1, 강좌를 수강신청2, 메뉴3");
			String fCode = keyboard.next();
			int gCode = Integer.parseInt(fCode);
			if (gCode == 1) {
				System.out.println("미리담기합니다.");
				pMiridamgiBasket.add(vLecture);
				return vLecture;
			}
			if (gCode == 2) {
				System.out.println("수강신청합니다.");
				pSincheongBasket.add(vLecture);
				return vLecture;
			}
			if (gCode == 3) {
				System.out.println("메뉴로 돌아갑니다.");
				return null;
			}
		}

		if (iCode == 1) {
			System.out.println("미리담기합니다.");
			return vLecture;
		}
		if (iCode == 2) {
			System.out.println("수강신청합니다.");
			return vLecture;
		}
		return vLecture;
	}

}
