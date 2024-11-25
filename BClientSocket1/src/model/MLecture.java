package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class MLecture {

	public Vector<VLecture> getVLectureVector(String fileName) {
		Vector<VLecture> vLectureVector = null;
		try {
			vLectureVector = new Vector<VLecture>();
			Scanner file = new Scanner(new File("data/"+fileName));
			while (file.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.load(file);
				vLectureVector.add(vLecture);
			}
			file.close();
		} catch(FileNotFoundException e) {

			e.printStackTrace();
		}
		return vLectureVector;
	}
}
