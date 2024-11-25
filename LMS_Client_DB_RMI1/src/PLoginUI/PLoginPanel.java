package PLoginUI;

import javax.swing.JPanel;

public class PLoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PTextField puserIdField;
	private PTextField ppasswordField;
	private PLoginButtonPanel pbuttonPanel;

	public PLoginPanel() {

		this.puserIdField = new PTextField("사용자 ID");
		this.add(this.puserIdField);

		this.ppasswordField = new PTextField("비밀번호");
		this.add(this.ppasswordField);
		
		this.pbuttonPanel = new PLoginButtonPanel();
		this.add(this.pbuttonPanel);

	}

	public void initialize() {
		this.pbuttonPanel.associate(this.puserIdField, this.ppasswordField);
		this.puserIdField.initialize();
		this.ppasswordField.initialize();
		this.pbuttonPanel.initialize();
	}
}
