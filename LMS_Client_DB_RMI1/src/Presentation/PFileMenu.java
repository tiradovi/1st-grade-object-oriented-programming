package Presentation;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import PLoginUI.PLoginFrame;
import valueObjectServer.VUserInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem exitItem;
	private JMenuItem logoutItem;
	private JMenuItem myaccountItem;
	private VUserInfo clientVUserInfo;

	public PFileMenu() {
		super("파일");

		ActionHandler actionHandler = new ActionHandler();

		this.newItem = new JMenuItem("새창");
		this.add(this.newItem);
		this.newItem.addActionListener(actionHandler);

		this.openItem = new JMenuItem("열기");
		this.add(this.openItem);
		this.openItem.addActionListener(actionHandler);

		this.myaccountItem = new JMenuItem("내 정보");
		this.add(this.myaccountItem);
		this.myaccountItem.addActionListener(actionHandler);

		this.logoutItem = new JMenuItem("로그아웃");
		this.add(this.logoutItem);
		this.logoutItem.addActionListener(actionHandler);

		this.exitItem = new JMenuItem("종료");
		this.add(this.exitItem);
		this.exitItem.addActionListener(actionHandler);
	}

	private void openNewMainFrame() {
		PMainFrame newMainFrame = new PMainFrame();
		newMainFrame.setVisible(true);
	}
    public void setClientVUserInfo(VUserInfo vUserInfo) {
        this.clientVUserInfo = vUserInfo;
    }

    private void showMyAccountInfo() {
        if (clientVUserInfo != null) {
            String id = clientVUserInfo.getUserId();
            String name = clientVUserInfo.getName();
            JOptionPane.showMessageDialog(this, "아이디: " + id + "\n이름: " + name);
        } else {
            JOptionPane.showMessageDialog(this, "로그인 정보가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
        }    if (clientVUserInfo != null) {
            myaccountItem.setEnabled(true);
            logoutItem.setEnabled(true);
        } else {
            myaccountItem.setEnabled(false);
            logoutItem.setEnabled(false);
        }
    }
    
	private void logoutAndOpenLoginFrame() {
		PLoginFrame loginFrame = new PLoginFrame();
		loginFrame.setVisible(true);
	}

	private void exitApplication() {
		System.exit(0);
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == newItem) {
				openNewMainFrame();
			} else if (e.getSource() == openItem) {

			} else if (e.getSource() == myaccountItem) {
				showMyAccountInfo();
			} else if (e.getSource() == logoutItem) {
				logoutAndOpenLoginFrame();
			} else if (e.getSource() == exitItem) {
				exitApplication();
			}
		}
	}

	public void initialize() {

	}
}
