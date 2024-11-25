package Presentation;

import javax.swing.JMenuBar;

public class PMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private PFileMenu flieMenu;
	public PMenuBar() {
		this.flieMenu = new PFileMenu();
		this.add(this.flieMenu);

	}

	public void initialize() {
		this.flieMenu.initialize();
	}

}
