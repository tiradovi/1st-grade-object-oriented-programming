package control;

import java.util.Vector;

import model.MLecture;
import valueObject.VLecture;

public class CLecture {

	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	public Vector<VLecture> getVLectureVector(String fileName) {
		Vector<VLecture> vLectureVector = mLecture.getVLectureVector(fileName);
		return vLectureVector;
	}
}
