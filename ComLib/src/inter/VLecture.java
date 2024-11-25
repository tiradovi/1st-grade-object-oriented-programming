 package inter;

import java.util.Scanner;

public class VLecture {
	private int code;
	private String name;
	private String lecturer;
	private int credit;
	private String time;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void load(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setLecturer(file.next());
		this.setCredit(file.nextInt());
		this.setTime(file.next());
	}

	public void show() {
		System.out.println(this.getCode() 
				+ " " + this.getName()
				+ " " + this.getLecturer() 
				+ " " + this.getCredit()
				+ " " + this.getTime());
	}
}