package PLoginUI;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PLoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// 자식
	private PLoginPanel loginPanel;

	public PLoginFrame() throws HeadlessException {
//자식 추가
		this.loginPanel = new PLoginPanel();
		this.add(this.loginPanel);

// 속성값 세팅		
		setTitle("로그인");
		setSize(310, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		String iconPath = "C:\\eclipsework\\mjuicon.jpg";
		ImageIcon icon = new ImageIcon(iconPath);
		setIconImage(icon.getImage());

	}

	public void initialize() {
		this.loginPanel.initialize();
	}

}
