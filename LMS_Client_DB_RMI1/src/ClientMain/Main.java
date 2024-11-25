package ClientMain;

import PLoginUI.PLoginFrame;

public class Main {
	private PLoginFrame loginFrame;

	public Main() {
		this.loginFrame = new PLoginFrame();

	}

	public void initialize() {
		loginFrame.initialize();

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
	}
}
