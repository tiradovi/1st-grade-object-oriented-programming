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
		System.out.println(message + " �ڵ� �Է�");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				selectedIndex = 0;
			}
		}

		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();

		return selectedFileName;
	}

	private VLecture findLecture(String message, String fileName, Scanner keyboard) {

		System.out.println(message + " �ڵ� �Է�");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				sCode = keyboard.next();
				iCode = Integer.parseInt(sCode);
				selectedIndex = 0;
			}
		}
		VLecture vLecture = vLectureVector.get(selectedIndex);
		return vLecture;
	}

	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard, int iCode) {
		String campusFileName = this.findIndex("ķ�۽�", "root", keyboard);
		String collegeFileName = this.findIndex("����", campusFileName, keyboard);
		String departmentFileName = this.findIndex("�а�", collegeFileName, keyboard);
		VLecture vLecture = this.findLecture("����", departmentFileName, keyboard);

		if (iCode == 0) {
			System.out.println("���¸� �̸����1, ���¸� ������û2, �޴�3");
			String fCode = keyboard.next();
			int gCode = Integer.parseInt(fCode);
			if (gCode == 1) {
				System.out.println("�̸�����մϴ�.");
				pMiridamgiBasket.add(vLecture);
				return vLecture;
			}
			if (gCode == 2) {
				System.out.println("������û�մϴ�.");
				pSincheongBasket.add(vLecture);
				return vLecture;
			}
			if (gCode == 3) {
				System.out.println("�޴��� ���ư��ϴ�.");
				return null;
			}
		}

		if (iCode == 1) {
			System.out.println("�̸�����մϴ�.");
			return vLecture;
		}
		if (iCode == 2) {
			System.out.println("������û�մϴ�.");
			return vLecture;
		}
		return vLecture;
	}

}
