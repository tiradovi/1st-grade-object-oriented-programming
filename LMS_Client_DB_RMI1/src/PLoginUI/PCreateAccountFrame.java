package PLoginUI;

import java.awt.event.ActionListener;
import javax.swing.*;

import Client.CCreateaccount;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PCreateAccountFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PTextField nameField;
	private CCreateaccount createAccountHandler;
	private PTextField puserIdField;
	private PTextField ppasswordField;

	public PCreateAccountFrame() {

		setTitle("회원 가입");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(3, 2));

		puserIdField = new PTextField("아이디");
		ppasswordField = new PTextField("비밀번호");
		nameField = new PTextField("이름");

		JButton registerButton = new JButton("등록");
		createAccountHandler = new CCreateaccount();

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = puserIdField.getText();
				String password = ppasswordField.getText();
				String name = nameField.getText();

				if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "모든 항목을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
				} else {
					// 추가된 코드
					createAccountHandler.createAccount(id, password, name);
					JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					dispose(); // 창 닫기
				}
			}
		});

		JLabel idLabel = new JLabel("ID:");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel nameLabel = new JLabel("이름:");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);

		panel.add(idLabel);
		panel.add(puserIdField);
		panel.add(passwordLabel);
		panel.add(ppasswordField);
		panel.add(nameLabel);
		panel.add(nameField);

		add(panel, BorderLayout.CENTER);
		add(registerButton, BorderLayout.SOUTH);
	}
}
