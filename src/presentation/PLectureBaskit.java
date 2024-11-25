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
	        System.out.println("과목이 추가되었습니다.");
	    }
	}

	public boolean isScheduleConflict(String newTime) {
		for (VLecture vLecture : vLectureVector) {
			String existingTime = vLecture.getTime();
			if (existingTime.equals(newTime)) {
				System.out.println("시간이 겹치므로 신청불가능합니다.");
				return true;
			}
		}
		return false;
	}
	public boolean isCodeConflict(int newCode) {
	    for (VLecture vLecture : vLectureVector) {
	        int existingCode = vLecture.getCode();
	        if (existingCode == newCode) {
	            System.out.println("강의 코드가 겹치므로 신청할 수 없습니다.");
	            return true;
	        }
	    }
	    return false;
	}

	public void remove(int index) {
		int adjustedIndex = index - 1;

		if (adjustedIndex >= 0 && adjustedIndex < vLectureVector.size()) {
			vLectureVector.remove(adjustedIndex);
			System.out.println("과목이 삭제되었습니다.");
		} else {
			System.out.println("유효하지 않은 인덱스입니다. 삭제할 과목을 선택하지 않았습니다.");
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
		System.out.println("원하는 기능을 선택해주세요 1. 과목 열람 2. 과목 삭제 3.메뉴");
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		if (iCode == 1) {
			this.show();
			this.PLectureBaskitrun(keyboard);
		}
		if (iCode == 2) {
			System.out.println("삭제하고 싶은 과목의 순서를 입력하세요");
			this.show();
			sCode = keyboard.next();
			iCode = Integer.parseInt(sCode);
			this.remove(iCode);
			this.PLectureBaskitrun(keyboard);
		}

	}

}
