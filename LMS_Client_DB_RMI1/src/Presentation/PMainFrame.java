package Presentation;

import java.awt.BorderLayout;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// 자식
	private PMenuBar menuBar;
	private PMainPanel mainPanel;

	public PMainFrame() throws HeadlessException {
		// 속성값 세팅
		setTitle("LMS");
		this.setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String iconPath = "C:\\eclipsework\\mjuicon.jpg";
		setResizable(false);
		ImageIcon icon = new ImageIcon(iconPath);
		setIconImage(icon.getImage());

		// 자식 추가
		this.menuBar = new PMenuBar();
		this.add(this.menuBar, BorderLayout.NORTH);

		this.mainPanel = new PMainPanel();
		this.add(this.mainPanel, BorderLayout.CENTER);

	}

	public void initialize() {
		this.menuBar.initialize();
		this.mainPanel.initialize();
	}
}
