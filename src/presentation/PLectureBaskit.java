package presentation;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class PLectureBaskit {
	private Vector<VLecture> vLectureVector;

	public PLectureBaskit() {

		this.vLectureVector = new Vector<VLecture>();
	}

	public void add(VLecture vLecture) {
	    String newTime = vLecture.getTime();
	    int newCode = vLecture.getCode();

	    if (!isScheduleConflict(newTime) && !isCodeConflict(newCode)) {
	        this.vLectureVector.add(vLecture);
	        System.out.println("������ �߰��Ǿ����ϴ�.");
	    }
	}

	public boolean isScheduleConflict(String newTime) {
		for (VLecture vLecture : vLectureVector) {
			String existingTime = vLecture.getTime();
			if (existingTime.equals(newTime)) {
				System.out.println("�ð��� ��ġ�Ƿ� ��û�Ұ����մϴ�.");
				return true;
			}
		}
		return false;
	}
	public boolean isCodeConflict(int newCode) {
	    for (VLecture vLecture : vLectureVector) {
	        int existingCode = vLecture.getCode();
	        if (existingCode == newCode) {
	            System.out.println("���� �ڵ尡 ��ġ�Ƿ� ��û�� �� �����ϴ�.");
	            return true;
	        }
	    }
	    return false;
	}

	public void remove(int index) {
		int adjustedIndex = index - 1;

		if (adjustedIndex >= 0 && adjustedIndex < vLectureVector.size()) {
			vLectureVector.remove(adjustedIndex);
			System.out.println("������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("��ȿ���� ���� �ε����Դϴ�. ������ ������ �������� �ʾҽ��ϴ�.");
		}
	}

	public void show() {
		for (VLecture vLecture : vLectureVector) {
			vLecture.show();
		}
	}

	public boolean isCreditLimitExceeded(int limit) {
		int totalCredit = 0;
		for (VLecture vLecture : vLectureVector) {
			totalCredit += vLecture.getCredit();
		}
		return totalCredit > limit;
	}

	public void PLectureBaskitrun(Scanner keyboard) {
		System.out.println("���ϴ� ����� �������ּ��� 1. ���� ���� 2. ���� ���� 3.�޴�");
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		if (iCode == 1) {
			this.show();
			this.PLectureBaskitrun(keyboard);
		}
		if (iCode == 2) {
			System.out.println("�����ϰ� ���� ������ ������ �Է��ϼ���");
			this.show();
			sCode = keyboard.next();
			iCode = Integer.parseInt(sCode);
			this.remove(iCode);
			this.PLectureBaskitrun(keyboard);
		}

	}

}
