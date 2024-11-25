package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VIndex;

public class MIndex {

	public Vector<VIndex> getVIndexVector(String fileName) {
		Vector<VIndex> vIndexVector = null;
		try {
			vIndexVector = new Vector<VIndex>();
			Scanner file = new Scanner(new File("data/" + fileName ));
			while (file.hasNext()) {

				VIndex vIndex = new VIndex();
				vIndex.load(file);
				vIndexVector.add(vIndex);

			}

			file.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return vIndexVector;
	}
}
