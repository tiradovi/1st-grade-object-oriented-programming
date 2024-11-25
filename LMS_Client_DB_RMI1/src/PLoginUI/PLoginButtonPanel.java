package PLoginUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Client.CLogin;
import Presentation.PMainFrame;
import inter.ILogin;
import valueObjectServer.VUserInfo;

public class PLoginButtonPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton PLoginButton;
    private JButton PCreateaccountButton;
    private JButton PExitButton;
    private PTextField puserIdField;
    private PTextField ppasswordField;

    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private int loginAttempts = 0;

    private static final int MIN_ID_LENGTH = 2;
    private static final int MAX_ID_LENGTH = 10;
    private static final int MIN_PASSWORD_LENGTH = 2;
    private static final int MAX_PASSWORD_LENGTH = 10;

    public PLoginButtonPanel() {
        ActionHandler actionHandler = new ActionHandler();

        this.PLoginButton = new JButton("로그인");
        this.PLoginButton.addActionListener(actionHandler);
        this.add(this.PLoginButton);

        this.PCreateaccountButton = new JButton("회원가입");
        this.PCreateaccountButton.addActionListener(actionHandler);
        this.add(this.PCreateaccountButton);

        this.PExitButton = new JButton("나가기");
        this.PExitButton.addActionListener(actionHandler);
        this.add(this.PExitButton);
    }

    public void associate(PTextField puserIdField, PTextField ppasswordField) {
        this.puserIdField = puserIdField;
        this.ppasswordField = ppasswordField;
    }

    public void initialize() {
        // 초기화 코드 추가
    }

    private void Loginbuttonaction() {
        String id = puserIdField.getText();
        String password = ppasswordField.getText();

        if (!validateInput(id, password)) {
            return;
        }

        ILogin clogin = new CLogin();
        VUserInfo VUserInfo;

        try {
            VUserInfo = clogin.getUserInfo(id, password);

            if (VUserInfo != null) {
                JOptionPane.showMessageDialog(null, "로그인 성공, " + VUserInfo.getName() + "님 안녕하세요!", "로그인",
                        JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.getWindowAncestor(this).dispose();
                PMainFrame mainFrame = new PMainFrame();
                mainFrame.initialize();
                loginAttempts = 0;
            } else {
                loginAttempts++;

                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                    JOptionPane.showMessageDialog(null, "로그인 3회 실패로 계정이 잠겼습니다.", "계정 잠김",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패 (남은 시도 횟수: " + (MAX_LOGIN_ATTEMPTS - loginAttempts) + ")", "로그인 실패",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private boolean validateInput(String id, String password) {
        if (id.length() < MIN_ID_LENGTH || id.length() > MAX_ID_LENGTH) {
            JOptionPane.showMessageDialog(null, "아이디는 " + MIN_ID_LENGTH + "자 이상, " + MAX_ID_LENGTH + "자 이하로 입력해주세요.", "입력 오류",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            JOptionPane.showMessageDialog(null, "비밀번호는 " + MIN_PASSWORD_LENGTH + "자 이상, " + MAX_PASSWORD_LENGTH + "자 이하로 입력해주세요.", "입력 오류",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void CreateaccountButtonaction() {
        PCreateAccountFrame createAccountFrame = new PCreateAccountFrame();
        createAccountFrame.setVisible(true);
    }

    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == PLoginButton) {
                Loginbuttonaction();
            }
            if (e.getSource() == PCreateaccountButton) {
                CreateaccountButtonaction();
            }
            if (e.getSource() == PExitButton) {
                System.exit(0);
            }
        }
    }
}
